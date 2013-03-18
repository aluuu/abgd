(ns abgd.core
  (:use
   [clojure.string :only [split-lines join]])
  (:require
   [jayq.core :as jq]
   [tailrecursion.javelin-demos.dom :refer [form-cell html!]])
  (:require-macros [tailrecursion.javelin.macros :refer [cell]]))

(defn start []
  (let [source-input (form-cell "#source")
        source-list (cell (split-lines source-input))
        dest-output (cell (html! "#dest" (join "\n" (sort source-list))))]))

(jq/document-ready start)
