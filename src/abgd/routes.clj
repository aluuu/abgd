(ns abgd.routes
  (:use compojure.core
        [hiccup core page]
        [hiccup.middleware :only (wrap-base-url)])
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            [compojure.response :as response]
            [ring.middleware.reload :as reload]))

(defn index-page []
  (html5
   [:head
    [:title "&#945;&#946;&#947;&#948;"]
    (include-css
     "http://fonts.googleapis.com/css?family=PT+Sans"
     "/bootstrap/css/bootstrap.min.css"
     "/bootstrap/css/bootstrap-responsive.min.css"
     "/css/page.css")]
   [:body {:class "b-body container"}
    [:div {:class "b-toolbox span12 m-center m-top-big-margin"}
     [:div {:class "b-header"}
      [:h4 "&#945;&#946;&#947;&#948;"]
      [:h2 "Сортировка списка по алфавиту"]]
     [:div {:class "m-top-big-margin"}
      [:i {:class "b-arrow m-to-button"}]
      [:em {:class "b-button-holder"}
       [:button {:class "btn btn-large b-button disabled" :id "js-sort"}
        "Сортировать"]]
      [:i {:class "b-arrow m-from-button"}]]
     [:div {:class "b-textarea-holder span12 m-top-margin"}
      [:textarea {:class "b-textarea" :id "js-source"}]
      [:textarea {:class "b-textarea" :id "js-destination"}]]]
    (include-js
     "/js/jquery-1.9.1.min.js"
     "/js/cljs.js"
     "/bootstrap/js/bootstrap.min.js")]))

(defroutes
  main-routes
  (GET "/" [] (index-page))
  (route/resources "/")
  (route/not-found "Not found"))

(def app
  (->
   main-routes
   (reload/wrap-reload)))