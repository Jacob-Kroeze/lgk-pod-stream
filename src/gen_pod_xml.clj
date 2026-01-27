(ns gen-pod-xml
  (:require [clj-rss.core :as rss]
            [buddy.core.hash :as hash]
            [buddy.core.codecs :as codecs]
            [clojure.java.io :as io]))

;DatatypeConverter


(defn md5-fn [url]
  (codecs/bytes->hex (hash/md5 (io/input-stream url))))



(defonce md5 (memoize md5-fn))

(let [ch-url "https://raw.githubusercontent.com/Jacob-Kroeze/lgk-pod-stream/refs/heads/main/pod.xml"]
  (->> (rss/channel-xml false {:title       "For Inky"
                               :link        ch-url
                               :description "Media for one"
                               :image       [{:url "https://media-public-pod.s3.us-west-2.amazonaws.com/art/Cover_Art.png"}]
                               :itunes [{:block "Yes"}]
                               }
                        [ {:title     "Consider Yourself"
                           :pubDate   (java.time.Instant/parse "2026-01-26T22:10:16.971601500Z")
                           :image     [{:url ""}]
                           :author    "JLK"
                           :guid      (md5 "https://media-public-pod.s3.us-west-2.amazonaws.com/04-consider-yourself.mp3")
                           :enclosure [{:url    "https://media-public-pod.s3.us-west-2.amazonaws.com/04-consider-yourself.mp3"
                                        :type   "audio/mp3"
                                        :length (+ (* 5 60) 51)}]}
                         {:title     "Animals Crossing at 3am"
                          :pubDate  (java.time.Instant/parse  "2026-01-27T22:10:16.971601500Z")
                          :image [{:url ""}]
                          :author "JLK"
                          :guid (md5 "https://media-public-pod.s3.us-west-2.amazonaws.com/animal-crossing-at-3am.aac")
                          :enclosure [{:url  "https://media-public-pod.s3.us-west-2.amazonaws.com/animal-crossing-at-3am.aac"
                                       :type "audio/aac"}]}])
    (spit "pod.xml")
    ))

(comment
  (slurp "pod.xml"))
