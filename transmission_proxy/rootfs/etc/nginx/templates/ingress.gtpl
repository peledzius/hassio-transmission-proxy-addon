
server {
    listen 9091 default_server;

    include /etc/nginx/includes/server_params.conf;

	allow   172.30.32.2;
    deny    all;
    
    location / {
        proxy_pass http://backend/transmission/web/;
        proxy_pass_header X-Transmission-Session-Id;
        include /etc/nginx/includes/proxy_params.conf;
    } 
    
    location /rpc {
        proxy_pass http://backend/transmission/rpc;
    }
    
    location /upload {
        proxy_pass http://backend/transmission/upload;
    }
}
