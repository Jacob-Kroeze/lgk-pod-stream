(ns gen-pod-xml
  (:require [clj-rss.core :as rss]
            [buddy.core.hash :as hash]
            [buddy.core.codecs :as codecs]
            [clojure.java.io :as io]))

;DatatypeConverter



(let [ch-url "https://raw.githubusercontent.com/Jacob-Kroeze/lgk-pod-stream/refs/heads/main/pod.xml"
      url "https://media-public-pod.s3.us-west-2.amazonaws.com/04-consider-yourself.mp3"
      _ (defonce md5 (hash/md5 (io/input-stream url)))
      ;md5 (hash/md5 (io/input-stream url))
      ;size (io/buffer-size (io/input-stream url))
      ]
  (->> (rss/channel-xml {:title       "For Inky"
                         :link        ch-url
                         :description "Media for one"
                         ;:itunes:duration    (+ (* 5 60) 51)
                         ;:pubDate     "Sun, 25 Jan 2026 18:00:00 -0500"               ; todo formatting
                         ;:size        size
                         ;:type-tag "audio/mpeg"
                         ;:enclosure {:url url :type "audio/mpeg"}
                         ;:guid md5
                         }
                        [{:title     "Consider Yourself"

                          :pubDate   (java.time.Instant/now)
                          :image     [{:url "https://commons.wikimedia.org/wiki/File:Moscow_et_Owana_de_l%E2%80%99%C3%A9levage_Of_Kolyma_Wolves.jpg?uselang=fr"}]
                          :author    "JLK"
                          :guid      (codecs/bytes->hex md5)
                          :enclosure [{:url url :type "audio/mp3" :lenght (+ (* 5 60) 51)}]}])
       (spit "pod.xml")
       ))

(comment
  (slurp "pod.xml"))
