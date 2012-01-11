(ns overtone-seq.demo.basic
  (:use [ overtone-seq.phrases]
        [ overtone-seq.compilation]
        [ overtone-seq.play]
        [ overtone-seq.decorations]
        [ overtone.core]))

(definst little-bit-of-bass [note 60  dur 0.5 depth 1.5 lfo 30.0]
  (let [
        freq (midicps note)
        freq (+ freq (* depth (pulse lfo)))
        ]
    * 1.0
    (env-gen (perc) (line:kr 1.0 0.0 dur) :timeScale dur :action FREE )
    (square freq)

    ))


(defn bass-line []
  (with-voice
    little-bit-of-bass
    (with-octave -2
      (phrase {:offset 0.0 :length 40.0}
              (repeat 10 
                      [:i (dotted-pair nil :i+)])
              )))
  )

(defn tune [] (compile-tune {:key-signature [(note :d3) :dorian]} [ ( bass-line)]))
(defn play []
  (play-tune (tune) (metronome 140))
  ) 

;; (play)