(ns overtone-seq.demo.pachelbels-canon-tune
  (:use overtone-seq.phrases overtone-seq.decorations)
  )

(def violoncello
  (let [
        main-seq [[:i+ :v :vi :iii] [ :iv :i :iv :v]]
        final [ [:i nil nil nil]]
        reps 28]    
    (with-octave -2
      (phrase
       {:offset  0.0 :length  (* 8 (+ 1 reps))}
       (concat (take reps (repeat main-seq)) [final] ))))) 

;; For clarity/rehearsal, these are split into 2/4 bar chunks
(def canon-parts
  {
   1 [
      [ :iii+ :ii+ :i+ :vii]  ;; crotchets
      [ :vi :v :vi :vii]]
   2 [ [ :i+ :vii :vi :v]
       [:iv :iii :iv :ii]]
   3 [ [
        [:i :iii] ;; quavers/half notes
        [:v :iv]
        [:iii :i]
        [:iii :ii]
        ]
       [
        [:i :vi-]
        [:i :v]
        [:iv :vi]
        [:v :iv]
        ]]
   4 [ [
        [:iii :i]
        [:ii :vii]
        [:i+ :iii+]
        [:v+ :v]
        ]
       [
        [:vi :iv]
        [:v :iii]
        [:i :i+]
        [
         (trill :i+ :ii+ :vii)]]]

   5 [
      [
       [:i+ :vii :i+ :i]
       [:vii- :v :ii :iii ]
       [:i :i+ :vii :vi]
       [:vii :iii+ :v+ :vi+]]
      [
       [:iv+ :iii+ :ii+ :iv+]
       [:iii+ :ii+ :i+ :vii]
       [:vi :v :iv :iii]
       [:ii :iv :iii :ii]]
      
      ]

   6 [
      [
       [:i :ii :iii :iv]
       [:v :ii :v :iv]
       [:iii :vi :v :iv]
       [:v :iv :iii :ii]
       ]
      [
       [:i :vi- :vi :vii]
       [:i+ :vii :vi :v]
       [:iv :iii :ii :vi]
       [:v :vi :v :iv]
       ]
      ]

   7 [
      [
       [:iii :iii+]
       :ii+
       [nil :i+]
       :iii+
       ]
      [
       :vi+
       :v+
       :vi+
       :vii+
       ]
      [
       [:i++ :i+]
       :vii
       [nil :vi]
       :i+
       ]
      [
       (dotted-pair :i+ :i+)
       [ [:i+ :iv+]
         [:ii+ :v+]]
       ]
      ]
   8 [
      [
       [
        :v+
        [:iii+ :iv+]
        :v+
        [:iii+ :iv+]
        ]
       [
        [:v+ :v :vi :vii]
        [:i+ :ii+ :iii+ :iv+]
        ]
       [
        :iii+
        [:i+ :ii+]
        :iii+
        [:iii :iv]
        ]
       [[ :v :vi :v :iv ]
        [:v :iii :iv :v]]
       ]

      [
       [ :iv [ :vi :v] :iv [:iii :ii]]
       [
        [:iii :ii :i :ii]
        [:iii :iv :v :vi]
        ]
       [ :iv [:vi :v] :vi [:vii :i+] ]
       [
        [:v :vi :vii :i+]
        [:ii+ :iii+ :iv+ :v+]
        ]
       ]
      [
       [:iii+ [:i+ :ii+] :iii+ [:ii+ :i+ ]]
       [[:ii+ :vii :i+ :ii+] [:iii+ :ii+ :i+ :vii]]
       [:i+ [:vi :vii] :i+ [:i :ii]]
       [
        [:iii :iv :iii :ii] [:iii :i+ :vii :i+]
        ]
       ]
      [
       [
        :vi [:i+ :vii]
        :vi [:v :iv]
        ]
       [
        [:v :iv :iii :iv]
        [:v :vi :vii :i+]
        ]

       [
        :vi [:i+ :vii]
        :i+ [:vii :vi]
        ]
       [[:vii :i+ :ii+ :i+] [:vii :i+ :vi  :vii] ]
       ]
      ]
   9 [
      (map pizzicato [:i+ nil :vii nil :vi nil :i+ nil])
      (map pizzicato [:i nil :i nil :i nil :ii nil])
      (map pizzicato [ nil :v nil :v nil :iii nil :v])
      (map pizzicato [ nil :iv nil :iii nil :iv nil :ii+])
      ]
   10
   [
    [
     [:iii+ :iii :iv :iii]
     [:ii :ii+ :iii+ :ii+ ]
     [:i+ :iii :i :vi]
     [:v :v- :iv- :v-]
     ]
    [
     [:vi- :vi :vii :vi]
     [:v :v- :iv- :v-]
     [:vi- :vi :v :vi]
     [:vii :vii- :vi- :vii-]
     ]
    [
     [:i :i+ :ii+ :i+]
     [:vii :vii- :i :vii-]
     [:vi- :vi :v :vi]
     [:vii :vii- :iii :ii]
     ]
    [
     [:i :i+ :ii+ :iv+]
     [:iii+ :iii :v :iii+]
     [:i+ :iv+ :iii+ :iv+]
     [:ii+ :v :iv :v]
     ]
    ]
   11 [
       [
        [:iii :v :v :v]
        (repeat 4 :v)
        (repeat 4 :iii)
        [:iii :iii :v :v]
        ]
       [
        [:iv :iv :iv :i+]
        (repeat 4 :i+)
        [:i+ :i+ :vi :vi]
        [:v :v :ii+ :vii]
        ]
       [
        [:v :iii+ :iii+ :iii+]
        (repeat 4 :ii+)
        (repeat 4 :i+)
        (repeat 4 :v+)
        ]
       [
        (repeat 4 :vi+)
        (repeat 4 :v+)
        (repeat 4 :vi+)
        [:vii+ :vii :vii :vii]
        ]
       
       ]
   12 [
       [
        [:i+ [:i :ii] :iii :i ]
        [:vii- [ :vii :i+] :ii+ :vii ]
        [:vi [ :vi- :vii-] :i :vi- ]
        [:vii- [:v :iv] :iii :ii ]]
       [
        [:i [:iv :iii] :ii :iv]
        [:iii [:i :ii] :iii :v ]
        [:iv [:vi :v] :iv :iii]
        [:ii [:v :iv] :iii :ii ]
        ]
       [
        [:iii [:i+ :vii] :i+ :iii]
        [:v [:v :vi] :vii :v]
        [:iii [:i+ :ii+] :iii+ :i+]
        [:iii+ [:iii+ :ii+] :i+ :vii]
        ]

       [
        [:vi [:vi :v] :vi :vii ]
        [:i+ [:iii+ :ii+] :i+ :iii+ ]
        [:iv+ [:i+ :vii] :vi :vi ]
        [:v :ii :v :v]
        ]

       ]
   13 [
       [
        (dotted-pair :v :v)
        (dotted-pair :i :v)]
       [
        :iv :v [:iv :i]
        (trill :i :ii :vii-)
        ]
       [
        [:i :i+] :vii :vi :v ]

       [
        (dotted-pair :i :ii)
        :iii
        :vi
        (dotted-pair  :ii :ii)
        ]
       ]
   14 [
       [
        (dotted-pair :iii :iii+)
        [:iii+ :iv+ :iii+ :ii+]
        (dotted-pair :i+ :i+)
        [:i+ :ii+ :i+ :vii]
        ]
       [
        :vi
        :i+
        [:i+ :viib :vi :viib] ;; ooh accidentals
        (dotted-pair :v :v)
        ]
       [
        (dotted-pair  :v :v+)
        [:v+ :vi+ :v+ :iv+]
        (dotted-pair :iii+ :iii+)
        [:iii+ :iv+ :iii+ :ii+]
        ]
       [
        [:i+ :viib :vi :viib]
        (dotted-pair :v :v)
        [:iv :i+]
        (dotted-pair :vii :vii)
        ]]
   15 [
       [
        ;; argh
        [:i+ :i+]
        [(tie :i+) :vii ]
        [(tie :vii) :vi]
        [(tie :vi ) :v ]
        ]
       [
        ;;;ARRGH
        [(tie :v) :iv ]
        [(tie :iv) :iii ]
        [(tie :iii) [(tie :iii) :ii]]
        :ii
        ]
       [
        [:iii :iii+]
        [(tie :iii+) :ii+ ]
        [:i+ :i++]
        [(tie  :i++) :viib+ ]
        ]
       [
        :vi+
        [:i++ :v+]
        :vi+
        :v+
        ]
       ]
   16 [
       [
        :v+
        (dotted-pair  :v :iv)
        :iii
        (dotted-pair :iii+ :ii+)
        ]
       [
        (dotted-pair :i+ :i+)
        [:i+ :vii]
        ]
       [
        [:i+ :i]
        [:vii- :vii]
        [:vi :vi-]
        [:v- :v]
        ]
       [
        [:iv :iv+]
        [:iii+ :iii]
        [:ii :vi]
        [:ii :ii+]
        ]
       [
        [:iii+ :iii]
        [:ii :ii+]
        [:i+ :i]
        [:vii- :vii]
        ]
       [
        [:vi :vi+]
        [:v+ :v]
        (dotted-pair :iv :ii+)
        [:v :v]
        ]
       ]
     
   })

(def final-bars
  [
   [
    :v nil nil nil
    ]
   [:iii+ nil nil nil]
   [:i+ nil nil nil]
   ]
  )

(defn make-canon-parts []
  "The canon starts in 2 bar intervals, with a 2 bar lead in. They all finish at the same time so we shorten each progressive canon part by 2 bars then append the final bar"
  (let [canon-line (apply concat (vals canon-parts))
        canon-line-length (* 4.0 (count canon-line))]
    
    (take 3 
          (map
           (fn [offset canon-line final-bar]
             (phrase
              {:offset offset :length (* 4.0 (inc (count canon-line)))}
               (concat canon-line [ final-bar])))
           (iterate #(+ 8.0 %) 8.0)
           (iterate #(drop-last 2 %) canon-line )
           final-bars
           )
          )))

(defn make-canon []
  (cons
   violoncello
   (make-canon-parts)
   )
  )