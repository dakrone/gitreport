(ns gitreport.core
  (:require [clojure.java.io :refer [reader output-stream writer]]
            [clojure.pprint :refer [pprint]]
            [gitreport.config :refer [config]]
            [gitreport.table :refer [tablify-issues]]
            [tentacles.users :as users]
            [tentacles.repos :as repos]
            [tentacles.issues :as issues])
  (:gen-class))

(def debug false)

(defn all-issues
  [auth source-user source-repo]
  (issues/issues source-user source-repo {:auth auth :all-pages true}))

;; (:html_url
;;  :labels
;;  :closed_at
;;  :number
;;  :milestone
;;  :comments
;;  :state
;;  :title
;;  :labels_url
;;  :updated_at
;;  :comments_url
;;  :locked
;;  :id
;;  :events_url
;;  :url
;;  :body
;;  :user
;;  :assignee
;;  :created_at)


(defn assigned? [assignee-list issue]
  (when-let [assignee (:assignee issue)]
    (some #{assignee} assignee-list)))

(defn format-issue [issue]
  (-> issue
      (select-keys [:title :assignee :html_url])
      ;; resolve huge assignee map to just login name
      (update-in [:assignee] :login)))

(defn formatted-issues
  [auth]
  (->> (all-issues auth (config :gh-owner) (config :gh-repo))
       (map format-issue)
       (filter (partial assigned? (config :gh-team)))
       (sort-by :assignee)))

(defn -main [& [creds action filename repouser reponame]]
  (println "Hello World"))
