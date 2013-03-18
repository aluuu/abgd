(defproject abgd "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [org.clojure/clojure-contrib "1.2.0"]
                 [ring "1.1.6"]
                 [org.clojure/tools.logging "0.2.3"]
                 [compojure "1.1.1"]
                 [jayq "2.0.0"]
                 [prismatic/dommy "0.0.2"]
                 [hiccup "1.0.2"]
                 [tailrecursion/javelin "1.0.0-SNAPSHOT"]]
  :plugins [[lein-cljsbuild "0.3.0"]
            [lein-ring "0.7.1"]
            [lein-git-deps "0.0.1-SNAPSHOT"]]
  :ring {:handler abgd.routes/app
         :auto-reload? true
         :auto-refresh true}
  :hooks [leiningen.cljsbuild]
  :cljsbuild {:builds
              [{:source-paths ["src-cljs"
                               ".lein-git-deps/javelin-demos/src/cljs/"]
                :id "main"
                :compiler
                {:pretty-print true
                 :output-to "resources/public/js/cljs.js"
                 :optimizations :simple}
                :jar true}]}
  :git-dependencies [["https://github.com/tailrecursion/javelin-demos.git"
                      "9ce34f76c6259d18341fe0b7e5a216543a480738"]]
  :main abgd.routes
  :jvm-opts ["-Xms512m" "-Xmx1024m"])
