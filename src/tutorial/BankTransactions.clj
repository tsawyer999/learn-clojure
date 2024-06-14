(ns tutorial.BankTransactions)

(def buyerAccount (ref 100))
(def merchantAccount (ref 0))
(def prices {'pen 1, 'notebook 5, 'backpack 90})
(def items (ref []))

(defn printInfo
  []
  (println "buyerAccount:" @buyerAccount)
  (println "merchantAccount:" @merchantAccount)
  (println "items:" @items)
  )

(defn buy
  [item]
  (def itemPrice (get prices item))
  (println "")
  (if (<= itemPrice @buyerAccount)
    (dosync
      (ref-set merchantAccount (+ @merchantAccount itemPrice))
      (ref-set buyerAccount (-@buyerAccount itemPrice))
      (def newItems (cons item @items))
      (ref-set items newItems)
      (println "===== Buy" item)
      )
    (println "===== Insufficient funds to buy" item)
    )
  (printInfo)
  )

(buy 'pen)
(buy 'notebook)
(buy 'backpack)
(buy 'notebook)
