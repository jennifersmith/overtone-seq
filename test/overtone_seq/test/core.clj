(ns overtone-seq.test.core
  ( :use overtone-seq.core
         clojure.test
         midje.sweet))

(fact
  "Basic phrase timings"
  (phrase-timings [ :a :b :c :d ]  0.0 4.0)
  => {
      0.0 {:a {:dur 1.0}}
      1.0 {:b {:dur 1.0}}
      2.0 {:c {:dur 1.0}}
      3.0 {:d {:dur 1.0}}
      }
  )

(fact "Phrase timings with division"
  (phrase-timings [:a :b [:c :d] :e] 0.0 4.0 )
  => {
      0.0 {:a {:dur 1.0}}
      1.0 {:b {:dur 1.0}}
      2.0 {:c {:dur 0.5}}
      2.5 {:d {:dur 0.5}}
      3.0 {:e {:dur 1.0}}
      }
  )