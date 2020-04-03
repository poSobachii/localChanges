package RSAencryption;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.RSADecrypter;
import com.nimbusds.jose.crypto.RSAEncrypter;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jwt.EncryptedJWT;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.bouncycastle.jcajce.provider.asymmetric.RSA;

import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class RSAnimbusNORexample {

    static ObjectMapper mapper = new ObjectMapper();
    static String token = "eyJlbmMiOiJBMTI4R0NNIiwiYWxnIjoiUlNBLU9BRVAtMjU2In0.chtf62Qz14PCOGGmVDtKcWh14bDRS63FnLPHBWVUoqjPyrBnXdfSkexHVgfHGWdS6imbjhnrGklyvijv6tu_CkYMCdm8Ezxr_9Ca23RNtJGe3DfXccOcD01a7jL1ZvweWqieT9Itfto8wJyzJz6ELGId8pEmOEagIDH-ylTEtbzuA3f8GS7fynY8mu018qtVNnP0u32zoWv02R1tU-IcXeNOVnW38h8xRXtrTWTa8cE0HNWPTfEXpiWSdF1vMtYh9DF2ZfQSj60jXe4z3lqfxw7r656n3Zp1MUaGS3a1P5pl8rqZv97ydFQpnfciw1_uEqoVZrmKyd_3o3u6PulbVA.IZWC2uJUx3xyEnlF.2dYBzPJdIKpsSVBXVBq8WQRB6XND4-q6YR1zvRSfk8W6lGKL-bgfOMbVnPP0nYCuH3Egh27ZnhmbOZYGOljIV4hHBz0IjEu7DQ99zu0nceUW5Cfw1f1Zluh4UTR6Y0GNyBBf_6oTwyt4rSG4L2afGNW-5-gnaXfn7CdpHxaQK2r_uCgsEeYEN0vBEIZe__nojNPqVr-LnYObmHXzdPKqmIxuYQLycfTR.45v1oyJM4oSX--QB8uEW7Q";
    static String token2 = "eyJ0dHlwIjoiaWRfdG9rZW4iLCJjdHkiOiJKV1QiLCJlbmMiOiJBMTI4R0NNIiwiYWxnIjoiUlNBLU9BRVAiLCJraWQiOiJwYXltZW50LXN0YWdpbmctNSJ9.ObfRI3Eo3X0kQkFODMl5ViH8Zbiko-pt7b5rB7vNLYonRtB9TbXxQGbUmtN_614hxugXYiRNMUkleNZSXzUUO2wY47tDqlIOPupd_Wode3Pup97RSwZrErX7rBamSRM8gCGLcyqbvA4_cqbid0RbmGess_uiwTyQwSDEvktT-b2yMLqBod9YR20fGzoLqQifIoOF4RAtb1fds-bNjekYzpfpq2iVUuz2Xm5_kijlIM0r5BC6oD4D-KK2cqGbne5WqLZGq0bDVYYzQDOdmfx8qcQrjdjU_ZVVIeB0-saaH9OJuiEf5193UthlfNk213Ku1mwxVpAgReDVDQhDDNu_Hw.-LthdOl1bHwSqrHn.r3lBixzyJt1WIxywuRqXN3QtZ-0Qv23j2MLgIbxsEYwFS9Vw7pcxxHmERxMF5D19UHBisO45xRAhVK4SHjIWinPelD-tY2R9qEGGmoMWmcQ6iadWeb13YsRtzLygcG9h4LSSDAZY_j_f1NZgUodUtuPchzpj-PI9NQLiPVa7I-tTER-XwkHBCJcgY-4VhMDlzX2AMbZ2BhYGCvw5WFtgBEedDE07b86iMNRjQJWiof9jE1T83p53y1ua084fBj4qZk0MoHWEsWRIyIMcgWwewyGRarTYc5pJaNU2JIePYOSExN3E_SbhzTDaD7FRDzOiHyepkNt7RyqqxxbzYXUGO_LXs92fmzgJXY1R37x2a4VmynA-BckjS8eigrxBN_AnVLhsDyKjaOCHLHecRGoOvgr8isuJnW5RTHab5JaTdCWd0ITUan9A2DBcxn4r8Q18c_dXRwku5tEt2bi1XVOeBN8XQNfwddis77v4n_04fBJWdwjSZ8GqC5mChYw5MgC4_h2D6_ZaS1bcK3SGXPxNpT89A-3fKhfqb_VtA0mkTww3OdWnnevJELtXkQdrUPjh8473fYVTcFFclxHmdC83lkPp5UMDymi1pN6qEOU2MRs7CMDzuWfqMsfwf7EZ5S7y8bNXvYyiOnixPb0XqdjbpRjD5NpQP9-NuO984oh0xUnuZSTyMVdtpySnPrGrpBMJJbHh1P3CrDhnOhBgSVhuzpndzHtgNlBJy3CXS5a_jJ8Ipedj4ImNweND9nnW6y5xxPqTJ_GZPpeS56fwd-z29TKCkVI-ENXIqxtqxLFhNcOtS_n1a79A84HNV-Q8UNvhT42F3vtR4ndqSMtVwL4OaWpGadYy11EFI3CUBeiedAWr0BxefRifdJFZuiKjehE4iXu1zA4VcitnMoRp1fwnRsG_EwdZ__2IL1Vr7QzV6cDoieK2uYmlFqFIzqF1lIQieWP9Cw6Gia6SwLAFQxO17qxCKdLxujFnpOVr1-R0ltYW0zxnBBoajZbPZOXYQbclYUuYvMkHvswi2Sk5svZ0K0h-yiFVu3sQwNYwN8TVw0wJm-HNND2BQbZKsN2E30YPyC_Tq1QxGGBFzO-jTrL8gWtERh7ThxNY76vmMIA2fsMmagQkfv0rHfT6pSjet97X_VAtNU5TpedCeJvZ9WlR0OgXbQ4ukFJx0vAy3mmf8nx4g3pTxb91U0zfyuc4p9c44UqrYRXrPMPt4pAxX79A3Ksdmv7Cnh_HZHvncjiTVpCeJv5zaZ1VIGLvJZgf6eTKbDKKjEaI2oPCyf-nipr8obZK3645nTRAWnFIRSi2K5GdZOrJujFRaom0GPez6mCPFQKv0kzI0lhmRTQ7y6DvM9FHfY-XEhNqshJt6AuA_1A7WoVIV2enNp0p8xnmvkuTVdH-4nJVzH7QMRVka__JXxNyKyhB1NK2MIhhG8-uQGtXi044G_47zR_wbkW2LlWzz_XJ3VvNzY3RAOhJ7jKFRokizoD0SR7PZkNg56iEA324soW0VcfOndt7CSBB3XDx2-5rubOanbRIqXWHqY1Zx8B8vd7spwML86p2s_kqQCPq28CAIXc6S5TsDMetB727tWb0a5i9Fr5ZSCl-dUKWXNOl7pGkZOKmHcs1K8ZKYg3iuBKPn5ndhItK8OK3Q12Q75n4mYSHlD3Ddg35UqHYhBecNfWEBX74luvu4En5mwnE6-cKWW_ulHM6IxalDiFiiD3HdUgmVYwkXd9jsKdmBv_ZQayYKQ9EONtD4We8B3HrtiaGcKs-6_L522RoHuKItO8F9q4vQjJqzGCVo9CpPoPeQNrprbXKIhxsUi4eFmK5KkCE9vSRWe8PPWEDagXUtJq2MbY6dKeQjqcnz8g54_D4YHSF1mNkxJ7K7POxvIuq9iCZu01K5L7nxJvt-WRpz8vcDTAZ4o5w85Kb2Bup_sPtdsUr8to6Phdin859xkfxaoTDn6xYldhQXON_wdoN2h3J6MajQuUOvHZl4kGTysvzumAhE7SL2nasqtrewv0ZQ63MrU0ldc9SBafYoFVy86Y1SeQAT2z5GcAnG79GX9LNGBNkoa4mTOuDqiz15G0vKjNRF4SH6UOjqu0r3JjFHKHaI6LwPY4Sb6nykWF8-fmLcF2YPjOife54z6Px-DDQa7Th-YZZCYPQeMesTwUZjTHO1xRkpsZLEOXyLNFyc2HraEC9boIhNzpig9mRj7PTyfhainvkzZntLKivCXj05HJUZo6icFxDFJg7jgiqUT2Ccv71YWRYe1N5BSQQ3DsL9pd0Ytf3gEE9PFFMXtCWdPC5m_XbD4HVw2aTWB1L5IkpY8Ny1Z6B5xFL1AtdoQ.b3JzBIFBjP8BPR1ZRlqEtQ";
    static String token3 = "eyJ0dHlwIjoiaWRfdG9rZW4iLCJjdHkiOiJKV1QiLCJlbmMiOiJBMTI4R0NNIiwiYWxnIjoiUlNBLU9BRVAiLCJraWQiOiJwYXltZW50LXN0YWdpbmctNSJ9.GxZXlJL5xEaoe3uoc95yK1ZX1eY8rn09ppsbfaEoudEkWC7LOz5iSBemFAvtMzUbI81HzzQfNwSnMFj57MhpQAh0QKMpR6N1GTJrAdxivT8uQABvl2KIRkN5DQpWDLTXEHjRhmTIxSIZ0IOjjB8DKO74eOP4JsCW0d4Eop9nD_EUSzOznq8HfyjA1_KrrxruUpT7VCdR1PZPlzIXvrotKPa98tEcf7yVvimtqqXBo10ijCOqAOefi8LpzAUaZ3ASqwcwSsva91s7C09JpGjFV1pCOd5U3bvpOvujjQpmyy41gRv1wgccMVzS2iFbC1og8hWsNVJznf5lWtz3aUYTrw.baSzHSTsDx2hl5_Y.WT3iUkv0fEenXWW7zUAeUUh7-APMqXpHtBuveU8-2FiEIoJrfuPcEfOgl9OL2pEa4Xs4rq7Az0EYqNCT8LuAr12MRhLtCs33AxAzcsDdS4AHwXnzrJXKtHjG_sfZt_bbPIYBze7Cl7tjsiuvvsHH4xEL5luJ8q4t951Mta8gc_4x6Ij7ZREgvL4y5IA4F3iouMkauLYrfqkL5eOSE2qctvMjBeJ91PEZmWxtkdZkWV2ufqoPRGZSejgNef5NqUeYxPdAKveI2fwftsEIQ9dC-Yu00sF-7Wg4G0V8ATkT-pgWRtHX6VsHWYU4ueoAiZJsOeJjOrm3SMMrBJdcKT4JAwZN4vK1tjPx6_x594uvfnctRQu98M6D0SiiuVrErpooTfIqAcg5QYFVNkyT667VZpU99woIP04lJ35hK_diVmM1RBIfOvoJcPynlxLcgrWnCMrsLjRpmMgubrK1s84pRV-kbSdhZWkzFV-ze8G17kMHKtY4V-wa3r8HhyV1-AMkyelwUrVeK3XpqiIcGMzaBvd8uj1MtNSHFEEJhTx4Sc3hC6lE8DLmyZOTQwYYj9Qadxm3PT2OSCqGNSgl8UsFIGR6bVdUuN2I8vlokvbjT9cZMUPOof0qq5-4OmMJxsryjtOQEWtRwMZLHUmII5NMOC0ZWj1ROzPJyaZxbGZ2R5aOPJYG7Q0GIgtVK0yawI_bnuwWEaZd59gqVmB_mRXQ8gQ7MfnXh2PLYkHVLZXAJI4_vSLGnRZACWKArf5HKrTVOQC_btgHBPn1YvklCgH6sTdb_lny07I_ox04rVIG1K7Z1iZp7E36F69VUrlw0J2vqZuXukoK1INFoVdLhCzZq8hpWmBbv6F0MftgQExRDCH2kkZdv17O5LrXlT7Dw-XuVuj6au7ZIvpuZ860hiLtEx3XVOGqQIo6Ce6JQyUoR2yLaVFY5dxJZGwYiPoPxcbCCa86pLxnsCrnrmw9l0yZjw3U0wf-PIAyN0-52kPkraBQxVuK065HuU-EM4cKttea_C6w4__zHYjgEbAKaBlVrg2IZF7SsjN03bN2-wop8p-mXYoOuknGsAY9XBKOGUWZ6hW-MSx4bcU-y5OxsTZB1yVdzCjxZyyysQelctcs9C7wwXC3r-4fTvd_ipoTprd8ridFMe9xb0jatMd2hbJT5zM4XWiwH_ueWPdRSkACPFaMByMOTRumFICDJLCxTLeiHemVtlrG2Qvz6qz0W4ss47dlRH4SH3cGqPwXKa89E3GuFveg1lJdvp8In6awGm-zq0dX4VEeAyrEuaP6DnajRzalSYx894sxDWs-AAN3jSMM5JvFif5vcYz_WHCgqn0PrsfgS71hx2AI3emtNTVQd6x3RDHJmJ6PR3MVOXXnarxtN3QHQPjKDh-Sp_yMSEoYgtSa4xrVdnTk1rGKnOGag52gYqlR4fMl0nZXV4zQ8fKPEEpWT-_qHav9urvrjXFgsXPuq7OGXQhVTAzpnb1HHxFqocVCx6EusNk_lbmaFnW8Zjv6FyaZTL3SNPxUzQdmlv4XKveQ0bUh4gHOyCY98FzmQkOLkHaUFT6FBHunDvlJ1glz3uIOV8Ep7aFgPDsYp320VQTyOwzp3r3sunV43LkH3abf_431tM4QgKa0Rl58N8Kz6zk6mHoIew5YcUC_4jcoVzxAf_XWdggdOR3RQe6W9VyYU_V6Pxln5P9QUQkZ_8esnRpZ8tfbBOme3o_Ai5bVe-vmRU9pXklBvgcs2BvKNE47g4IZfvF9dTydb8ApUGS0QWxm_SmJajN7aRmmnqEQPvfWeIXCNJI-vjh9rlS0Zj1L3UeT8Qxamd8ywb7veZw9EM6TkyR6HlsZbVbUMOFHmD8tiDT_o50nFOFG9EjB0oxrPBIM4Kf7vXkA-RU1Tev6JkBkDSrOtbCgdVwbxSdkyqmbltLyY0DyA-TN7Rop61ld_AV6ULl-IG_3cdx7jHmEWZgEm7oYbP_QwGIp4QpLw7OGPTtf2As2xxvRrqJb3wOiY4dCwA1WcJvQ9-D1j1J_n7E4MszaTg93AoIrf1fv0T3v-k0TNZp2iALFtb5oiqqwXDkZiY02O-cjtTIxCRZj-SePqJ3JEFf8MljJi4WQQMU-znDfJQM7iy2GP3MFa5JlLe5ZT0s0DAU2kEpwxz3HHO7eLrJcTGYiA6_rnjQztr2NZewX-a2jxopzFeK9BnsXtS6qpKxqqUwRqQpvQjzMPbddfMO1F2DCd5P9ahlpteruYGwk1yS6gNnETN1dCcgxwCieeu8rTlc5UKOQj0aUlAjZgAjyqZRumPc06gTELolC5xEs6Sau1o4o-S6QUj2Zaq-aiKpN2kLZy6Kux5ygYBMrveayrk9qGwq63jcb-8s8if1BKgaRT0IMSs4jz6cPvFyEFDaZjWQIv-EJCbHApAiGLCoy_-EhPb_aG7fdvOnlXrth6W2t7em5EyIDLI-1jqe3ProM6xXXIc9flHIxWLpsvIKUxeNqbZqo_HHLQQSh.HMdDU0SzwtHWQk6o8SO0Pg";
    static String token4 = "eyJraWQiOiJzb21lSUQiLCJlbmMiOiJBMTI4R0NNIiwiYWxnIjoiUlNBLU9BRVAtMjU2In0.lCXv-RBdUWFeW4t1CAyDNLEft_RBqp5SEFI-dQSincFKqwtVVUVO5a20OEgg03S4Z2OcPLNYxE4p00-JmndNZa-4j9jmAihG8JuQD8Qm4AfpSK0nOHczshVEelLxJq-4S1ci0T8qLWt6coB9ymMTSHTM9ZPmmpiVwDDDyCWiIGc3AC-4hckIw6g09Lr0K6t9n7GsIzR-AHZJnlSH_UoSwdbNsNu4AmEQMOvXAkDCZz5YlzGol5koyU3yjOXaOYlwalB1ynK7tZtSngs48yrHcMNok_W4s_DK6TxwWbN5pnNJw2VEO2XYxCuUAezTxNyicOIE2y8XzZXEXuAmj7OuxA.Bs4uCEFFXVhufrjr.fstXFTEy3YQ.EwPNcbWMM4s1QJm8jUkl9g";
    static String token5 = "eyJraWQiOiJzb21lSUQiLCJlbmMiOiJBMTI4R0NNIiwiYWxnIjoiUlNBLU9BRVAtMjU2In0.PEepqhDKiQRFUO1HQQtbKJPKNNorIFBsbXZk8bgq61kEJyt01H4ltJWHV3VDbImsvq9c1bBXB2K02vj7Z89z2GcJPflAfOHmTDh9Zki2LsrPPBDwjljybtsH4ZCeDu7FMmod5TcL4Vc368Nf0i4kphc-mtEmOkBh5QwvhYUSGcdOaEShBi4FlzqSqLujWvo50k_LkBwqnMdvTZBobKC5RENlQKGDh3DjMBMgeao6z06fg9RGjN4X7GrLtqepdtY_LqNZtRCy37bkQ9y8ZqxIXT7Ua_ef0cNDnt1j4UTmUftvvTKOYWXgE3-2OX9IT0B1MjVHvsx4AMEb138x4y28ng.IR9GjIEOSD0GfiYx.FwDpPEvCsyo.Te8MEkeUz0jp7vtsflLKLw";
    static String prodKeysToken1 = "eyJraWQiOiJzb21lSWQiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJhbGljZSIsImF1ZCI6InNvbWVvbmVBbm90aGVyIiwiaXNzIjoic29tZW9uZSIsImV4cCI6MTU2ODI4Njg3NiwianRpIjoiZTE4OTBlNmEtZjMzOS00ODhmLWI3YjYtYzk4YzE5NjQ0YzBiIn0.KyTuvPfCZARNBivY6ejShqcWRn2aMVznvBjttkMIB48GrPUXY0lyqegnhQsSoTSL9pNPLnBFhPu6xTdQZSTtj9QZO0fePwVkKN_MYMTFO9kEqonVZEKIfW3KZIf5zAq1kJWQwGw86PHXhMgISmUOOFC-jZdd_pvDFQk0C2KS3Jd1KedhQYZ_7d3dpYU5pI5QZ6-orxgxRkrrcgJDwFHQfKSln9YOB8OagUJx9lhqQyn-LAFV-fnlSvVd1c_yj6oNp2AY1FetpcNl0kSQadPCdJd8WA5PhDRyL5g89CnixsB12EkzvtQxp4WDtjRXqCPVsOcVZT9c1P6fvtsYn74E3w";
    static RSAPublicKey publicKey;
    static RSAPrivateKey privateKey;

    public static void main(String[] args) throws JOSEException, ParseException, NoSuchAlgorithmException, IOException, InvalidKeySpecException {
        RSAEncryptionFromFile.decodeToken();
        privateKey = RSAEncryptionFromFile.getPrivateKey();
//        publicKey = RSAEncryptionFromFile.getPublicKey();
        publicKey = fetchByID("payment-prod-01");
//        fetchNordeaPublic("demo-id-token");
//        nimbusEncodeEncrypted();
//        nimbusEncode();
        verifyOnlyToken();
//        nimbusDecode();

    }

    static void nimbusEncodeEncrypted() throws JOSEException {
        JWTClaimsSet jwtClaims = new JWTClaimsSet.Builder()
                .issuer("https://papi-staging.sanomaservices.nl")
                .audience("vsGhBdS67eNBy1faRUBy")
                .subject(UUID.randomUUID().toString())
                .expirationTime(new Date(2019, 07, 24))
                .jwtID(UUID.randomUUID().toString())
                .build();

        System.out.println(jwtClaims.toJSONObject());

        JWEHeader header = new JWEHeader(JWEAlgorithm.RSA_OAEP_256, EncryptionMethod.A128GCM);
        EncryptedJWT jwt = new EncryptedJWT(header, jwtClaims);
        RSAEncrypter encrypter = new RSAEncrypter(publicKey);
        jwt.encrypt(encrypter);
        String jwtString = jwt.serialize();

        System.out.println("Token=" + jwtString);
    }

    static void nimbusEncode() throws JOSEException {
        JWTClaimsSet jwtClaims = new JWTClaimsSet.Builder()
                .issuer("https://papi-staging.sanomaservices.nl")
                .audience("vsGhBdS67eNBy1faRUBy")
                .subject(UUID.randomUUID().toString())
                .expirationTime(new Date(2019, 07, 24))
                .jwtID(UUID.randomUUID().toString())
                .build();
        JWSSigner signer = new RSASSASigner(privateKey);
        JWSObject jwsObject = new JWSObject(new JWSHeader.Builder(JWSAlgorithm.RS256).keyID("someId").build(), new Payload(jwtClaims.toJSONObject()));
        jwsObject.sign(signer);

        System.out.println("token=" + jwsObject.serialize());

    }

    static void nimbusDecode() throws ParseException, JOSEException, IOException {
        EncryptedJWT jwt;
        RSADecrypter decrypter = new RSADecrypter(privateKey);
        jwt = EncryptedJWT.parse(token3);
        jwt.decrypt(decrypter);
        System.out.println("res2=" + jwt.getPayload());
        String finaltoken = jwt.getPayload().toString();


        SignedJWT nordeaToken = SignedJWT.parse(finaltoken);
        System.out.println("Header=" + nordeaToken.getHeader().getKeyID());
        RSAPublicKey nordeaKid = fetchNordeaPublic("nasf-access-token");
        RSASSAVerifier verifier = new RSASSAVerifier(nordeaKid);
        nordeaToken.verify(verifier);
        System.out.println("payload=" + nordeaToken.getPayload());
        tokenObjectFormat objectFormat = mapper.readValue(nordeaToken.getPayload().toString(), tokenObjectFormat.class);
        System.out.println("names=" + nordeaToken.getPayload().toString());

        System.out.println(nordeaToken.getJWTClaimsSet().getIssuer());
        System.out.println(nordeaToken.getJWTClaimsSet().getSubject());
        System.out.println(nordeaToken.getJWTClaimsSet().getAudience().size());
        System.out.println(nordeaToken.getJWTClaimsSet().getExpirationTime());
        System.out.println(nordeaToken.getJWTClaimsSet().getNotBeforeTime());
        System.out.println(nordeaToken.getJWTClaimsSet().getIssueTime());
        System.out.println(nordeaToken.getJWTClaimsSet().getJWTID());
    }


    public static RSAPublicKey fetchByID(String targetUrl) throws IOException, ParseException, JOSEException {
        JWKSet jwkSet = JWKSet.load(new URL("https://papi.sanomaservices.nl/payment/public/identification/keys"));
        JWK jwk = jwkSet.getKeyByKeyId(targetUrl);
        RSAKey key = (RSAKey) jwkSet.getKeys().get(0);
        RSAPublicKey pubkey = (RSAPublicKey) key.toPublicKey();
        System.out.println("JSON=" + jwk.toJSONString());
        System.out.println("KEY=" + pubkey);
        System.out.println("KEY2=" + Base64.getEncoder().encodeToString(pubkey.getEncoded()));

        return pubkey;

//        RSAPublicKey publicKey = ((RSAPublicKey)) jwk.toJSONString()
//
//        JwkProvider provider = new UrlJwkProvider(new URL("https://identify.nordea.com/api/dbf/ca/token-service-v3/keys"));
//        Jwk jwk = provider.get(targetUrl);
//        System.out.println(jwk);
//        RSAPublicKey RSApublicKey = (RSAPublicKey) jwk.getPublicKey();
//        return RSApublicKey;
//
//        JWKSet jwkSet = JWKSet.parse(body);
//        JWK jwk = jwkSet.getKeyByKeyId(keyId);
//        RSAPublicKey publicKey = ((RSAKey) jwk).toRSAPublicKey();
//        RSASSAVerifier verifier = new RSASSAVerifier(publicKey);
//        SignedJWT signedJWT = SignedJWT.parse(client_assertion_string);
//        boolean result = signedJWT.verify(verifier);

    }

    public static RSAPublicKey fetchNordeaPublic(String targetKID) throws IOException, ParseException, JOSEException {
        JWKSet jwkSet = JWKSet.load(new URL("https://identify.nordea.com/api/dbf/ca/token-service-v3/keys"));
        JWK jwk = jwkSet.getKeyByKeyId(targetKID);
        RSAKey key = (RSAKey) jwkSet.getKeys().get(0);
        RSAKey key2 = (RSAKey) jwkSet.getKeyByKeyId(targetKID);
        RSAPublicKey pubkey = (RSAPublicKey) key2.toPublicKey();
        System.out.println("KEY2=" + Base64.getEncoder().encodeToString(pubkey.getEncoded()));
        List<JWK> tempo = jwkSet.getKeys();
        List<RSAKey> tempo1= new ArrayList<>();
        for (JWK e : tempo) {
            tempo1.add((RSAKey) e);
        }
        for (RSAKey e : tempo1) {

        }

        return pubkey;
    }


    public static void verifyOnlyToken() throws ParseException, JOSEException {
        SignedJWT nordeaToken = SignedJWT.parse(prodKeysToken1);
        System.out.println("Header=" + nordeaToken.getHeader().getKeyID());
        RSASSAVerifier verifier = new RSASSAVerifier(publicKey);
        nordeaToken.verify(verifier);
        System.out.println("payload=" + nordeaToken.getPayload());
        System.out.println("names=" + nordeaToken.getPayload().toString());
    }

}

