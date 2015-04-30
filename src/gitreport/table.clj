(ns gitreport.table
  (:require [doric.core :refer [table org]]
            [gitreport.config :refer [config]]))

(defn format-url-org [url]
  (let [chunk (first (re-find #"(issues|pull)/\d+" url))]
    (str "[["
         "https://github.com/"
         (config :gh-owner)
         "/"
         (config :gh-repo)
         "/"
         chunk
         "]["
         chunk
         "]]")))

(defn format-url-markdown [url]
  (let [chunk (first (re-find #"(issues|pull)/\d+" url))]
    (str "["
         chunk
         "]("
         "https://github.com/"
         (config :gh-owner)
         "/"
         (config :gh-repo)
         "/"
         chunk
         ")")))

(defn tablify-issues [issues]
  (table {:format (config :table-format)}
         (config :doric-headers) issues))
