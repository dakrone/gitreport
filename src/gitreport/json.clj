(ns gitreport.json
  (:require [cheshire.core :as cheshire]))

(defn encode [obj]
  (cheshire/encode obj))

(defn decode [obj]
  (cheshire/decode obj true))
