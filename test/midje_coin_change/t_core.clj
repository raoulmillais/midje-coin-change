(ns midje_coin_change.t-core
  (:use midje.sweet)
  (:use [midje_coin_change.core]))

(facts "about coin-change"
  (fact "it returns no coins"
    (coin-change 10 []) => {}
    (coin-change 0 [1 5 10 25 100]) 
        => {1 0,
            5 0,
            10 0,
            25 0,
            100 0 })
  (fact "it returns all 1s when only 1s available"
    (coin-change 10 [1]) 
        => {1 10})
  (fact "it returns the smallest number of coins"
    (coin-change 133 [1 2 5 10 20 50 100])
        => {1 1,
            2 1,
            5 0,
            10 1,
            20 1,
            50 0,
            100 1}
    (coin-change 15 [1 5 10 25 100]) 
        => {1 0,
            5 1,
            10 1,
            25 0,
            100 0}))

(facts "about next-denom"
  (fact "it reduces amount remaining and adds coins to change"
    (next-denom {:remaining 17 :change {}} 5)
        => {:remaining 2 :change { 5 3 }}))
