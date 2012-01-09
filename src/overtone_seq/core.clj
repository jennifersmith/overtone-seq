(ns overtone-seq.core
  (:use overtone-seq.phrases
        overtone-seq.compilcation
        overtone-seq.decoration
        overtone-seq.play)
  )

(defn demo-notes [notes speed]
  (play-tune (make-tune
              {:key-signature [(note :C3) :major]}
              [(phrase {:offset 0.0 :length (* 4.0 (count notes))} notes)])
             (metronome speed)))

