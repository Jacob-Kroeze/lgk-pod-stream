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
                               :image       [{:url "https://media-public-pod.s3.us-west-2.amazonaws.com/art/Cover_Art.png"
                                              :title "Raised by Wolves"
                                              :link "https://media-public-pod.s3.us-west-2.amazonaws.com/art/Cover_Art.png" }]
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
                          :guid (md5 "https://media-public-pod.s3.us-west-2.amazonaws.com/animal-crossing-at-3am.mp3")
                          :enclosure [{:url  "https://media-public-pod.s3.us-west-2.amazonaws.com/animal-crossing-at-3am.mp3"
                                       :type "audio/mp3"}]}
                         {:title     "HW 2026-01-29"
                          :pubDate  (java.time.Instant/parse  "2026-01-29T22:10:16.971601500Z")
                          :image [{:url ""}]
                          :author "JLK"
                          :guid (md5 "https://media-public-pod.s3.us-west-2.amazonaws.com/hw-2026-01-29.mp3")
                          :enclosure [{:url   "https://media-public-pod.s3.us-west-2.amazonaws.com/hw-2026-01-29.mp3"
                                       :type "audio/mp3"}]}
                         {:title     "Battles - Atlas"
                          :pubDate  (java.time.Instant/parse  "2026-04-02T22:10:16.971601500Z")
                          :image [{:url ""}]
                          :author "JLK"
                          :guid (md5 "https://media-public-pod.s3.us-west-2.amazonaws.com/battles-atlas.mp3")
                          :enclosure [{:url   "https://media-public-pod.s3.us-west-2.amazonaws.com/battles-atlas.mp3"
                                       :type "audio/mp3"}]}
                         {:title     "Toy - Da Drum"
                          :pubDate (java.time.Instant/parse "2026-03-12T22:10:16.971601500Z")
                          :author "JLK"
                          :guid (md5 "https://media-public-pod.s3.us-west-2.amazonaws.com/drum-toy-eg.mp3")
                          :enclosure [{:url   "https://media-public-pod.s3.us-west-2.amazonaws.com/drum-toy-eg.mp3"
                                       :type "audio/mp3"}]}
                         {:title "Meanie master bullet"
                          :pubDate  (java.time.Instant/parse "2026-04-07T00:10:16.971601500Z")
                          :author "JLK"
                          :guid (md5 "https://media-public-pod.s3.us-west-2.amazonaws.com/Meanie__Master_Bullet_OST.mp3")
                          :enclosure [{:url "https://media-public-pod.s3.us-west-2.amazonaws.com/Meanie__Master_Bullet_OST.mp3"
                                       :type "audio/mp3"}]}
                         {:title "Overtime minigame mayhem ost"
                          :pubDate  (java.time.Instant/parse "2026-04-07T00:10:16.971601500Z")
                          :author "JLK"
                          :guid (md5 "https://media-public-pod.s3.us-west-2.amazonaws.com/Overtime__Minigame_Mayhem_OST.mp3")
                          :enclosure [{:url "https://media-public-pod.s3.us-west-2.amazonaws.com/Overtime__Minigame_Mayhem_OST.mp3"
                                       :type "audio/mp3"}]}
                         {:title "Minigame mayhem ost"
                          :pubDate  (java.time.Instant/parse "2026-04-07T00:10:16.971601500Z")
                          :author "JLK"
                          :guid (md5 "https://media-public-pod.s3.us-west-2.amazonaws.com/Minigame_Mayhem__Minigame_Mayhem_OST+(1).mp3")
                          :enclosure [{:url "https://media-public-pod.s3.us-west-2.amazonaws.com/Minigame_Mayhem__Minigame_Mayhem_OST+(1).mp3"
                                       :type "audio/mp3"}]}
                         (let [url "https://media-public-pod.s3.us-west-2.amazonaws.com/Omnipresent.mp3"]
                           {:title     "Omnipresent"
                                     :pubDate   (java.time.Instant/parse "2026-04-12T00:10:16.971601500Z")
                                     :author    "JLK"
                                     :guid      (md5 url)
                                     :enclosure [{:url  url
                                                  :type "audio/mp3"}]})
                         (let [url "https://media-public-pod.s3.us-west-2.amazonaws.com/Darkness.mp3"]
                           {:title     "Darkness"
                            :pubDate   (java.time.Instant/parse "2026-04-12T00:10:16.971601500Z")
                            :author    "JLK"
                            :guid      (md5 url)
                            :enclosure [{:url  url
                                         :type "audio/mp3"}]})

                         ])
    (spit "pod.xml")
    ))

(comment
  (slurp "pod.xml"))
