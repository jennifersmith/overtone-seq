(ns overtone-seq.core)

(defmulti subphrase-timings (fn [_ current _ _]
                              (cond
                               (keyword? current) :note
                               (coll? current) :subphrase
                                    ) ))

(defmethod subphrase-timings :note [result current offset length]
  (assoc-in result [offset current] {:dur length} )
  )
(defmethod subphrase-timings :subprhase [result current offset length] :awesome)
(defn phrase-timings
  ([phrase offset length] (phrase-timings {} phrase offset length) )
  ([result phrase offset length]
                         (let
                             [beat-length (/ length (count phrase))]
                           (reduce
                            (fn [result [current offset]]
                              (subphrase-timings result current offset beat-length)
                              )
                            result
                            (map vector phrase (iterate #(+ beat-length %) offset ))
                            )
                           ))
  )