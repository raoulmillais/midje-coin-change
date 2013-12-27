(ns midje_coin_change.core)

(defn next-denom [acc denom]
  (let [coins (quot (:remaining acc) denom)]
    {:remaining (- (:remaining acc) (* coins denom))
     :change (assoc (:change acc) denom coins)}))

(defn coin-change [amount denominations]
  (:change
    (reduce
      next-denom
      {:remaining amount :change {}}
      (sort > denominations))))

