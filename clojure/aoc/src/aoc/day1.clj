(require '[clojure.string :as string])

(defn is-number? [c]
  (<= (int \0) (int c) (int \9)))

(defn token2nr [line]
  (loop [nr nil,
         pairs '("one" \1
                 "two" \2
                 "three" \3
                 "foun" \4
                 "five" \5
                 "six" \6
                 "seven" \7
                 "eight" \8
                 "nine" \9
                 )]
    (if (or nr (empty? pairs)) nr
        (if (string/starts-with? line (first pairs))
          (recur (second pairs) nil)
          (recur nil (rest (rest pairs)))))))

(defn get-numbers [line & nrs]
  (if (empty? line) (vec nrs)
      (recur
       (string/join (rest line))
       (if (is-number? (first line))
         (conj (vec nrs) (first line))
         (if-let [nr (token2nr line)]
           (conj (vec nrs) nr) nrs)))))
      
(defn process-lines [lines]
  (apply
   + (map (comp
           #(Integer/parseInt %)
           #(if (empty? %) 0 %)
           #(string/join (list (first %) (last %)))
           ;; #(filter is-number? %))
           get-numbers)
          (string/split-lines lines))))

(def example1 "1abc2
pqr3stu8vwx
a1b2c3d4e5f
treb7uchet")

(def example2 "eightwothree
abcone2threexyz
xtwone3four
4nineeightseven2
zoneight234
7pqrstsixteen")
