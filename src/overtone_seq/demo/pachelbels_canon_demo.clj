(ns overtone-seq.demo.pachelbels-canon-demo
  (:use [ overtone-seq.phrases]
        [ overtone-seq.compilation]
        [ overtone-seq.play]
        [ overtone-seq.demo.pachelbels-canon-tune]
        [ overtone.core])
  )

;; define some basic instruments (they are not suppose to sound like
;; their names)

(definst crap-cello [note 60  dur 0.5]
  (let [freq (midicps note)]
    (* 0.7
       (env-gen (asr 0.1 1.0 0.5) (line:kr 1.0 0.0 dur) :timeScale dur :action FREE )
       (lpf (saw freq) 3000)
       )))

(definst crap-violin [note 60  dur 0.5]
  (let [freq (midicps note)]
    (* 0.6
       (env-gen (asr 0.3 1.0 0.5) (line:kr 1.0 0.0 dur) :timeScale dur :action FREE )
       (sin-osc freq)
       )))

(defn phrases-with-instruments []
  (map
   #(with-voice %1 %2)
   (cons crap-cello (repeat 3 crap-violin))
   (make-canon)))

(defn compile-canon [root scale]
  (compile-tune {:key-signature [(note root) scale]} ( phrases-with-instruments) )
  )

(defn play-pachelbels-canon [root scale]
  (play-tune (compile-canon root scale) (metronome 65) )
  )

;; correct
;; (play-pachelbels-canon root scale)