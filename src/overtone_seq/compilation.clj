(ns overtone-seq.compilation
  (:use overtone.music.pitch))
(defn- degree->pitch [root scale degree]
  (if (keyword? degree)
    (+  root (degree->interval degree scale))
    degree))

(defn resolve-note [{:keys [key-signature octave]} note]
  (if-let [[root scale] key-signature]
    (+ (* 12 (or octave 0))
       (degree->pitch  root scale note))
    note
    )
  )


(defn assoc-note [tune {:keys [offset length properties note-properties]} note]
  (let [note (resolve-note properties note)]
    (assoc-in tune
              [:events offset note]
              (merge note-properties {:dur length}))))

(defn assoc-phrase [tune {:keys [ notes offset length] :as phrase}]
  (let [beat-length (/ length (count notes))]
    (reduce 
     (fn [result [ note-or-subphrase offset]]
       (let [subphrase
             (assoc phrase :offset offset :length beat-length :notes note-or-subphrase)]
         (cond
          (fn? note-or-subphrase)   (note-or-subphrase result subphrase)
          (coll? note-or-subphrase) (assoc-phrase result subphrase)
          (nil? note-or-subphrase) result
          :else (assoc-note result subphrase note-or-subphrase )
          ))
       )     
     tune
     (map vector notes (iterate #(+ beat-length %) offset )))))

(defn make-tune [tune-properties phrases]
  (reduce
   assoc-phrase
   {}
   (map
    #(update-in % [:properties] (partial merge tune-properties) )
    phrases)
   )
  )