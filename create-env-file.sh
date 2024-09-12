#!/bin/sh

# .env 파일 생성
cat <<EOF > /app/nftlix-nft-mint/.env
API_URL=$API_URL
PRIVATE_KEY=$PRIVATE_KEY
PUBLIC_KEY=$PUBLIC_KEY
EOF
