pgrep kubectl | xargs kill -9
kubectl port-forward services/argocd-server 1234:80 -n argocd &
kubectl port-forward services/pyramid-routing-app-routes-app 8080:80 -n pyramid-routing-app &
kubectl port-forward services/pyramid-routing-app-environment-infrastructure-app 8083:80 -n pyramid-routing-app &
kubectl port-forward services/pyramid-routing-app-geography-app 8084:80 -n pyramid-routing-app &
kubectl port-forward services/pyramid-routing-app-weather-app 8085:80 -n pyramid-routing-app &

