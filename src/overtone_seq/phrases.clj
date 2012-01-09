(ns overtone-seq.phrases)

(defn with-octave [octave phrase]
  (assoc-in phrase [:properties :octave] octave))

(defn with-voice [voice phrase]
  (assoc-in phrase [:note-properties :voice ] voice))

(defn phrase
  [attributes phrase-notes]
  (assoc
      attributes
      :notes phrase-notes))

(defn delay-phrase [amount phrase]
  (update-in [:offset] #(+ amount %)))

;; NOT WORKING
;;
;; ( defn assoc-parallel-phrase [tune phrase offset length]
;;   (reduce
;;    (fn [result note-or-subphrase]
;;      (assoc-phrase result [ note-or-subphrase] offset length))
;;    tune
;;    phrase))

