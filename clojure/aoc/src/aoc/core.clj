(ns aoc.core
  (:gen-class))

(defn is-number? [c]
  (<= (int \0) (int c) (int \9)))

(defn get-numbers [line]
  (let [nrs (filter is-number? (seq line))]
      (clojure.string/join (list (first nrs) (last nrs)))))

(def numbers
  "token - number pairs"
  '(("one" "1")
   ("two" "2")
   ("three" "3")
   ("foun" "4")
   ("five" "5")
   ("six" "6")
   ("seven" "7")
   ("eight" "8")
   ("nine" "9")))

(defn get-numbers-advanced [line]
    ;; (if first (seq line))
    ))

(defn process-lines [lines]
  (apply +
         (map #(Integer/parseInt %)
              (remove empty?
                      (map get-numbers
                           (clojure.string/split-lines lines))))))

(defn example1 []
  (let [data "1abc2
pqr3stu8vwx
a1b2c3d4e5f
treb7uchet"]
    (process-lines data)))

(defn example2 []
  (let [data "eightwothree
abcone2threexyz
xtwone3four
4nineeightseven2
zoneight234
7pqrstsixteen"
        ]
    (process-lines data)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
