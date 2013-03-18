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
     "/bootstrap/css/bootstrap.min.css"
     "/bootstrap/css/bootstrap-responsive.min.css"
     "/css/page.css")]
   [:body {:class "container"}
    [:div {:class "span12 centrify"}
     [:h3 {:class "centrify"} "&#945;&#946;&#947;&#948;"]
     [:div {:class "centrify"}
      [:button {:class "btn btn-large disabled top-buffer"}
       "Сортировать"]]
     [:div {:class "span12 top-buffer"}
      [:textarea {:class "textarea" :id "source"}]
      [:textarea {:class "textarea" :id "dest"}]]]
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