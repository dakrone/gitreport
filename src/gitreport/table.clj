(ns gitreport.table
  (:require [doric.core :refer [table org]]
            [gitreport.config :refer [config]]))

(defn tablify-issues [issues]
  (table {:format org} (keys (first issues)) issues))
