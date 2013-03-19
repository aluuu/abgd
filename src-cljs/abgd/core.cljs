(ns abgd.core
  (:use
   [clojure.string :only [split-lines join]])
  (:require
   [jayq.core :as jq]
   [clojure.browser.event :as event]
   [tailrecursion.javelin-demos.dom :refer [form-cell html! by-id]])
  (:require-macros [tailrecursion.javelin.macros :refer [cell]]))

(defn start []
  (let [sort-button (jq/$ "#js-sort")
        source-input (form-cell "#js-source")
        sorted-list (cell (sort
                           (filter
                            (comp not empty?)
                            (split-lines source-input))))
        button-enabled? (cell (> (count sorted-list) 1))]

    (cell ((if button-enabled? jq/remove-class jq/add-class) sort-button "disabled"))

    (jq/bind sort-button "click"
             #(if @button-enabled?
                (html! "#js-destination" (join "\n" @sorted-list))))))

(jq/document-ready start)
