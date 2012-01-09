(ns overtone-seq.play
  (:use [overtone.core])
  )

(defn- play-timeslice [metro offset notes]
  (let
       [beat-length (/ 1 (/ (metro :bpm) 60)) ]
   (at (metro offset)
       (doall
        (map #((:voice (val %))
               :note (key %)
               :dur (* beat-length (:dur (val % ))))
             notes)))))

(defn- play-subseq [subsequence start metro]
  
  (doall
   (map
    #(play-timeslice metro (+ start (first %)) (second %))
    subsequence)))

(defn play-tune [{:keys [events]} metro]
  (let
      [
       beat-length (/ 1 (/ (metro :bpm) 60)) 
       start (metro)
       times (partition 80 80 [] (sort (keys events)))
       ]
    (doall
     (map
      #(apply-at (metro (+ start (first %)))
                #'play-subseq
                [(select-keys events %) start metro]) times))))
