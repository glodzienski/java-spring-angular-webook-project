package webbook.api.entity;

import javax.persistence.*;

@Entity
@Table(name = "oauth_refresh_token")
public class OauthRefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "token_id")
    private String tokenId;

    @Lob
    @Column(name = "token", columnDefinition = "bytea")
    private byte[] token;

    @Lob
    @Column(name = "authentication", columnDefinition = "bytea")
    private byte[] authentication;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public byte[] getToken() {
        return token;
    }

    public void setToken(byte[] token) {
        this.token = token;
    }

    public byte[] getAuthentication() {
        return authentication;
    }

    public void setAuthentication(byte[] authentication) {
        this.authentication = authentication;
    }
}