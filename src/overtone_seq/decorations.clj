(ns overtone-seq.decorations
  (:use overtone-seq.compilation))

(defn tie [note]
  "This note is tied to the previous note to increase its duration. Use this when you need to hold over a division (like across a bar)"
  (fn [result {:keys [offset length] :as phrase}]
    (let 
        [note (resolve-note (:properties phrase) note)]
     (if-let
         [previous-offset
          (first
           (filter
            #(get-in result [:events % note])
            (sort-by #(- offset %) (keys (:events result))) ))
          ]
       (update-in result [:events previous-offset note :dur] + length)
       result
       ))))
;; ornaments!
;; Trill is upper-lower-upper in pre 1800s music dontchaknow
(defn trill [note upper & remainder]
  "Trills the given note with the upper 4 times, less any remaining notes in this division"
  (let [trill-length (- 4 (count remainder))]
    (concat
     (take trill-length (repeat [upper note]))
     remainder)))

(defn dotted-pair [note next]
  "Extend note by half and allow next to take up the remaining part of the division"
  [ note [(tie note) next]])

;; pizz is basically playing the notes but shorter - so [:i :ii]
;; becomes [[:i ___] [:ii ___]]
;; later this could be an arg to an instrument which can mess with its env
(defn pizzicato [note]
  "Play the given note pizzicatio - at present this just means making it 1/4 as short"
  [note nil nil nil]
  )
