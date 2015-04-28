(ns gitreport.config
  (:require [carica.core :as carica]))

(def config carica/config)
(def override-config carica/override-config)

(defn reload []
  (carica/clear-config-cache!))
