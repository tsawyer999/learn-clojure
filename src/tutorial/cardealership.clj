(ns tutorial.cardealership)

(defn getDiscount
  [code]
  (if (= "20Percent" code)
    (do
      (println "The code is valid")
      0.8
      )
    (do
      (println "The code is invalid")
      1
      )
    )
  )

(defn getCarPrices
  [budget code cars]

  (def discount (getDiscount code))

  (doseq [car cars]
    (def carType (first car))
    (def price (last car))
    (def priceDiscount (* price discount))

    (if (<= priceDiscount budget)
      (println "The" carType "costs" priceDiscount)
      )
    )
  )

(def cars {
           "bmw" 60000,
           "ferrari" 100000,
           "fiat" 20000}
  )
(getCarPrices 50000 "20Percent", cars)
