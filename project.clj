(defproject gitreport "0.1.0"
  :description "Lee's awesome Github reporting tool for team lead-ing"
  :url "http://writequit.org"
  :license {:name "Apache License"
            :url "https://www.apache.org/licenses/LICENSE-2.0.txt"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [cheshire "5.4.0"]
                 [clj-http "1.1.1"]
                 [doric "0.9.0"]
                 [sonian/carica "1.1.0"]
                 [tentacles "0.3.0"]]
  :resource-paths ["etc"]
  :aot [gitreport.core]
  :main gitreport.core)
