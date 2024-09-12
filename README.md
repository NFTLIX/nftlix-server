<h3> 🎨 이미지 변환 및 NFT metadata 생성 서비스, NFTLIX-SERVER </h3>   

- 회원가입/로그인 API
- NFT 상품 생성 API (nftlix-ai 서비스와 연동)
- NFT 상품 목록 조회 API
- NFT 상품 단일 조회 API
- NFT minting API (nftlix-nft-mint 서비스와 연동)


## 🔗 Download (Docker image)
```bash
docker pull ghcr.io/nftlix/nftlix-server:latest
```

## 🪄 Usage
```bash
docker run -d -p 8080:8080 \
-e DB_HOSTNAME=your-db-hostname \
-e DB_PORT=your-db-port \
-e DB_DATABASE=your-db-name \
-e DB_USERNAME=your-db-username \
-e DB_PASSWORD=your-db-password \
-e API_URL=your-nft-mint-api-url \
-e PRIVATE_KEY=your-nft-mint-private-key \
-e PUBLIC_KEY=your-nft0-mint-public-key \
ghcr.io/nftlix/nftlix-server:latest
```

## 📑 Docs
[NFTLIX Server API Docs](https://api.nftlix.store/nftlix-docs.html)

## 🧩 System Architecture
![서버 아키텍쳐](https://github.com/user-attachments/assets/1a07e3bb-38c1-42c9-8b4e-120707195b19)


