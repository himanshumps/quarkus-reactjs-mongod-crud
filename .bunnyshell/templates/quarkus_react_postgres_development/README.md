## Developer template (do not use for production)
  
### Overview
  
This Environment Template is a boilerplate for **creating a developer environment** based on a stack using Java 17 with [Quarkus](https://quarkus.io/) for exposing the REST API, basic [ReactJS](https://react.dev/) for frontend and [Postgres](https://www.postgresql.org/) as the database.

The interaction between the UI and the backend application is CORS enabled.

The template created for Hackathon provides the Bunnyshell configuration composed of 3 Components (frontend + backend + database) and the CRUD application that demonstrates how the components work together to form an environment.

### Environment overview
  
This Environment Template contains 3 components:
  
- `react-app` for frontend, based on a `node` image (0.50 CPU and 256 MB RAM)
- `quarkus-applicaton` for backend, also based on a `ubi9/openjdk17` image (0.50 CPU and 256 MB RAM)
- `postgres-db` using a `postgres` image (1 Core CPU and 512 MB RAM)
  
and 1 persistent volume:
  
- `postgres-volume` (128Mb disk space)
  
### Technologies used:
  
### Back-End:
  
- Java
- Quarkus
- Hibernate Panache
- Postgres Database
  
### Front-End:
  
- React-router-dom 5+
- Axios 1.4.0 
- Bootstrap 4.5.0
  
### Images Used
  
- [Redhat UBI9 OpenJDK 19](https://catalog.redhat.com/software/containers/ubi9/openjdk-17/61ee7c26ed74b2ffb22b07f6)
  
- [Node 18 LTS Alpine](https://hub.docker.com/layers/library/node/18.12-alpine3.17/images/sha256-b375b98d1dcd56f5783efdd80a4d6ff5a0d6f3ce7921ec99c17851db6cba2a93?context=explore)
  
- [Postgres 15.3 Alpine](https://hub.docker.com/layers/library/postgres/15.3-alpine3.18/images/sha256-58a4e7ae605e8e247180ebba1cc3758ab20677e9a5221ab3150a74f47938b8a1?context=explore)
  
## Customization of the image using environment variable

The RedHat UBI image and the quarkus application provide a ton of flags to modify the application behaviour using environment variables.

The Java Runtime startup parameters that are available are as follows:

<table>
    <thead>
        <tr>
            <th>Configuration property</th>
            <th>Type</th>
            <th>Default</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>
                <strong>quarkus.http.cors</strong><br />
                Enable the CORS filter.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_CORS
            </td>
            <td>boolean</td>
            <td>false</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.port</strong><br />
                The HTTP port<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_PORT
            </td>
            <td>int</td>
            <td>8080</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.test-port</strong><br />
                The HTTP port used to run tests<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_TEST_PORT
            </td>
            <td>int</td>
            <td>8081</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.host</strong><br />
                The HTTP host In dev/test mode this defaults to localhost, in prod mode this defaults to 0.0.0.0 Defaulting to 0.0.0.0 makes it easier to deploy Quarkus to container, however it is not suitable for dev/test mode as other
                people on the network can connect to your development machine.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_HOST
            </td>
            <td>string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.host-enabled</strong><br />
                Enable listening to host:port<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_HOST_ENABLED
            </td>
            <td>boolean</td>
            <td>true</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.ssl-port</strong><br />
                The HTTPS port<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SSL_PORT
            </td>
            <td>int</td>
            <td>8443</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.test-ssl-port</strong><br />
                The HTTPS port used to run tests<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_TEST_SSL_PORT
            </td>
            <td>int</td>
            <td>8444</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.insecure-requests</strong><br />
                If insecure (i.e. http rather than https) requests are allowed. If this is enabled then http works as normal. redirect will still open the http port, but all requests will be redirected to the HTTPS port. disabled will
                prevent the HTTP port from opening at all.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_INSECURE_REQUESTS
            </td>
            <td>enabled, redirect, disabled</td>
            <td>enabled</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.http2</strong><br />
                If this is true (the default) then HTTP/2 will be enabled. Note that for browsers to be able to use it HTTPS must be enabled, and you must be running on JDK11 or above, as JDK8 does not support ALPN.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_HTTP2
            </td>
            <td>boolean</td>
            <td>true</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.cors.origins</strong><br />
                Origins allowed for CORS Comma separated list of valid URLs, e.g.: <a href="http://www.quarkus.io,http://localhost:3000" rel="nofollow">http://www.quarkus.io,http://localhost:3000</a> In case an entry of the list is
                surrounded by forward slashes, it is interpreted as a regular expression.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_CORS_ORIGINS
            </td>
            <td>list of string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.cors.methods</strong><br />
                HTTP methods allowed for CORS Comma separated list of valid methods. ex: GET,PUT,POST The filter allows any method if this is not set. default: returns any requested method as valid<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_CORS_METHODS
            </td>
            <td>list of string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.cors.headers</strong><br />
                HTTP headers allowed for CORS Comma separated list of valid headers. ex: X-Custom,Content-Disposition The filter allows any header if this is not set. default: returns any requested header as valid<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_CORS_HEADERS
            </td>
            <td>list of string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.cors.exposed-headers</strong><br />
                HTTP headers exposed in CORS Comma separated list of valid headers. ex: X-Custom,Content-Disposition default: empty<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_CORS_EXPOSED_HEADERS
            </td>
            <td>list of string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.cors.access-control-max-age</strong><br />
                The Access-Control-Max-Age response header value indicating how long the results of a pre-flight request can be cached.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_CORS_ACCESS_CONTROL_MAX_AGE
            </td>
            <td>Duration</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.cors.access-control-allow-credentials</strong><br />
                The Access-Control-Allow-Credentials header is used to tell the browsers to expose the response to front-end JavaScript code when the request’s credentials mode Request.credentials is “include”. The value of this header will
                default to true if quarkus.http.cors.origins property is set and there is a match with the precise Origin header and that header is not '*'.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_CORS_ACCESS_CONTROL_ALLOW_CREDENTIALS
            </td>
            <td>boolean</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.ssl.certificate.credentials-provider</strong><br />
                The CredentialsProvider. If this property is configured then a matching 'CredentialsProvider' will be used to get the keystore, keystore key and truststore passwords unless these passwords have already been configured.
                Please note that using MicroProfile ConfigSource which is directly supported by Quarkus Configuration should be preferred unless using CredentialsProvider provides for some additional security and dynamism.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SSL_CERTIFICATE_CREDENTIALS_PROVIDER
            </td>
            <td>string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.ssl.certificate.credentials-provider-name</strong><br />
                The credentials provider bean name.<br />
                It is the &amp;#64;Named value of the credentials provider bean. It is used to discriminate if multiple CredentialsProvider beans are available. It is recommended to set this property even if there is only one credentials
                provider currently available to ensure the same provider is always found in deployments where more than one provider may be available.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SSL_CERTIFICATE_CREDENTIALS_PROVIDER_NAME
            </td>
            <td>string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.ssl.certificate.files</strong><br />
                The list of path to server certificates using the PEM format. Specifying multiple files require SNI to be enabled.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SSL_CERTIFICATE_FILES
            </td>
            <td>list of path</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.ssl.certificate.key-files</strong><br />
                The list of path to server certificates private key file using the PEM format. Specifying multiple files require SNI to be enabled. The order of the key files must match the order of the certificates.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SSL_CERTIFICATE_KEY_FILES
            </td>
            <td>list of path</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.ssl.certificate.key-store-file</strong><br />
                An optional key store which holds the certificate information instead of specifying separate files.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SSL_CERTIFICATE_KEY_STORE_FILE
            </td>
            <td>path</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.ssl.certificate.key-store-file-type</strong><br />
                An optional parameter to specify type of the key store file. If not given, the type is automatically detected based on the file name.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SSL_CERTIFICATE_KEY_STORE_FILE_TYPE
            </td>
            <td>string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.ssl.certificate.key-store-provider</strong><br />
                An optional parameter to specify a provider of the key store file. If not given, the provider is automatically detected based on the key store file type.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SSL_CERTIFICATE_KEY_STORE_PROVIDER
            </td>
            <td>string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.ssl.certificate.key-store-password</strong><br />
                A parameter to specify the password of the key store file. If not given, and if it can not be retrieved from CredentialsProvider, then the default ("password") is used.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SSL_CERTIFICATE_KEY_STORE_PASSWORD
            </td>
            <td>string</td>
            <td>password</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.ssl.certificate.key-store-password-key</strong><br />
                A parameter to specify a CredentialsProvider property key which can be used to get the password of the key store file from CredentialsProvider.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SSL_CERTIFICATE_KEY_STORE_PASSWORD_KEY
            </td>
            <td>string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.ssl.certificate.key-store-key-alias</strong><br />
                An optional parameter to select a specific key in the key store. When SNI is disabled, if the key store contains multiple keys and no alias is specified, the behavior is undefined.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SSL_CERTIFICATE_KEY_STORE_KEY_ALIAS
            </td>
            <td>string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.ssl.certificate.key-store-key-password</strong><br />
                An optional parameter to define the password for the key, in case it’s different from key-store-password If not given then it may be retrieved from CredentialsProvider.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SSL_CERTIFICATE_KEY_STORE_KEY_PASSWORD
            </td>
            <td>string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.ssl.certificate.key-store-key-password-key</strong><br />
                A parameter to specify a CredentialsProvider property key which can be used to get the password for the key from CredentialsProvider.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SSL_CERTIFICATE_KEY_STORE_KEY_PASSWORD_KEY
            </td>
            <td>string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.ssl.certificate.trust-store-file</strong><br />
                An optional trust store which holds the certificate information of the certificates to trust.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SSL_CERTIFICATE_TRUST_STORE_FILE
            </td>
            <td>path</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.ssl.certificate.trust-store-file-type</strong><br />
                An optional parameter to specify type of the trust store file. If not given, the type is automatically detected based on the file name.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SSL_CERTIFICATE_TRUST_STORE_FILE_TYPE
            </td>
            <td>string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.ssl.certificate.trust-store-provider</strong><br />
                An optional parameter to specify a provider of the trust store file. If not given, the provider is automatically detected based on the trust store file type.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SSL_CERTIFICATE_TRUST_STORE_PROVIDER
            </td>
            <td>string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.ssl.certificate.trust-store-password</strong><br />
                A parameter to specify the password of the trust store file. If not given then it may be retrieved from CredentialsProvider.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SSL_CERTIFICATE_TRUST_STORE_PASSWORD
            </td>
            <td>string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.ssl.certificate.trust-store-password-key</strong><br />
                A parameter to specify a CredentialsProvider property key which can be used to get the password of the trust store file from CredentialsProvider.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SSL_CERTIFICATE_TRUST_STORE_PASSWORD_KEY
            </td>
            <td>string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.ssl.certificate.trust-store-cert-alias</strong><br />
                An optional parameter to trust only one specific certificate in the trust store (instead of trusting all certificates in the store).<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SSL_CERTIFICATE_TRUST_STORE_CERT_ALIAS
            </td>
            <td>string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.ssl.cipher-suites</strong><br />
                The cipher suites to use. If none is given, a reasonable default is selected.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SSL_CIPHER_SUITES
            </td>
            <td>list of string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.ssl.protocols</strong><br />
                The list of protocols to explicitly enable.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SSL_PROTOCOLS
            </td>
            <td>list of string</td>
            <td>TLSv1.3,TLSv1.2</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.ssl.sni</strong><br />
                Enables Server Name Indication (SNI), an TLS extension allowing the server to use multiple certificates. The client indicate the server name during the TLS handshake, allowing the server to select the right certificate.
                <br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SSL_SNI
            </td>
            <td>boolean</td>
            <td>false</td>
        </tr>
        <tr>
            <td>
                **quarkus.http.static-resources.index-page&lt;**br/&gt;Set the index page when serving static resources.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_STATIC_RESOURCES_INDEX_PAGE
            </td>
            <td>string</td>
            <td>index.html</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.static-resources.include-hidden</strong><br />
                Set whether hidden files should be served.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_STATIC_RESOURCES_INCLUDE_HIDDEN
            </td>
            <td>boolean</td>
            <td>true</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.static-resources.enable-range-support</strong><br />
                Set whether range requests (resumable downloads; media streaming) should be enabled.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_STATIC_RESOURCES_ENABLE_RANGE_SUPPORT
            </td>
            <td>boolean</td>
            <td>true</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.static-resources.caching-enabled</strong><br />
                Set whether cache handling is enabled.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_STATIC_RESOURCES_CACHING_ENABLED
            </td>
            <td>boolean</td>
            <td>true</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.static-resources.cache-entry-timeout</strong><br />
                Set the cache entry timeout. The default is 30 seconds.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_STATIC_RESOURCES_CACHE_ENTRY_TIMEOUT
            </td>
            <td>Duration</td>
            <td>30S</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.static-resources.max-age</strong><br />
                Set value for max age in caching headers. The default is 24 hours.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_STATIC_RESOURCES_MAX_AGE
            </td>
            <td>Duration</td>
            <td>24H</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.static-resources.max-cache-size</strong><br />
                Set the max cache size.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_STATIC_RESOURCES_MAX_CACHE_SIZE
            </td>
            <td>int</td>
            <td>10000</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.handle-100-continue-automatically</strong><br />
                When set to true, the HTTP server automatically sends 100 CONTINUE response when the request expects it (with the Expect: 100-Continue header).<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_HANDLE_100_CONTINUE_AUTOMATICALLY
            </td>
            <td>boolean</td>
            <td>false</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.io-threads</strong><br />
                The number if IO threads used to perform IO. This will be automatically set to a reasonable value based on the number of CPU cores if it is not provided. If this is set to a higher value than the number of Vert.x event loops
                then it will be capped at the number of event loops. In general this should be controlled by setting quarkus.vertx.event-loops-pool-size, this setting should only be used if you want to limit the number of HTTP io threads to
                a smaller number than the total number of IO threads.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_IO_THREADS
            </td>
            <td>int</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.limits.max-header-size</strong><br />
                The maximum length of all headers.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_LIMITS_MAX_HEADER_SIZE
            </td>
            <td>MemorySize</td>
            <td>20K</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.limits.max-body-size</strong><br />
                The maximum size of a request body.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_LIMITS_MAX_BODY_SIZE
            </td>
            <td>MemorySize</td>
            <td>10240K</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.limits.max-chunk-size</strong><br />
                The max HTTP chunk size<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_LIMITS_MAX_CHUNK_SIZE
            </td>
            <td>MemorySize</td>
            <td>8192</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.limits.max-initial-line-length</strong><br />
                The maximum length of the initial line (e.g. "GET / HTTP/1.0").<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_LIMITS_MAX_INITIAL_LINE_LENGTH
            </td>
            <td>int</td>
            <td>4096</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.limits.max-form-attribute-size</strong><br />
                The maximum length of a form attribute.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_LIMITS_MAX_FORM_ATTRIBUTE_SIZE
            </td>
            <td>MemorySize</td>
            <td>2048</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.limits.max-connections</strong><br />
                The maximum number of connections that are allowed at any one time. If this is set it is recommended to set a short idle timeout.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_LIMITS_MAX_CONNECTIONS
            </td>
            <td>int</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.idle-timeout</strong><br />
                Http connection idle timeout<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_IDLE_TIMEOUT
            </td>
            <td>Duration</td>
            <td>30M</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.read-timeout</strong><br />
                Http connection read timeout for blocking IO. This is the maximum amount of time a thread will wait for data, before an IOException will be thrown and the connection closed.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_READ_TIMEOUT
            </td>
            <td>Duration</td>
            <td>60S</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.body.handle-file-uploads</strong><br />
                Whether the files sent using multipart/form-data will be stored locally.<br />
                <br />
                If true, they will be stored in quarkus.http.body-handler.uploads-directory and will be made available via io.vertx.ext.web.RoutingContext.fileUploads(). Otherwise, the files sent using multipart/form-data will not be stored
                locally, and io.vertx.ext.web.RoutingContext.fileUploads() will always return an empty collection. Note that even with this option being set to false, the multipart/form-data requests will be accepted.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_BODY_HANDLE_FILE_UPLOADS
            </td>
            <td>boolean</td>
            <td>true</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.body.uploads-directory</strong><br />
                The directory where the files sent using multipart/form-data should be stored.<br />
                Either an absolute path or a path relative to the current directory of the application process.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_BODY_UPLOADS_DIRECTORY
            </td>
            <td>string</td>
            <td>${java.io.tmpdir}/uploads</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.body.merge-form-attributes</strong><br />
                Whether the form attributes should be added to the request parameters.<br />
                If true, the form attributes will be added to the request parameters; otherwise the form parameters will not be added to the request parameters<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_BODY_MERGE_FORM_ATTRIBUTES
            </td>
            <td>boolean</td>
            <td>true</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.body.delete-uploaded-files-on-end</strong><br />
                Whether the uploaded files should be removed after serving the request.<br />
                If true the uploaded files stored in quarkus.http.body-handler.uploads-directory will be removed after handling the request. Otherwise, the files will be left there forever.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_BODY_DELETE_UPLOADED_FILES_ON_END
            </td>
            <td>boolean</td>
            <td>true</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.body.preallocate-body-buffer</strong><br />
                Whether the body buffer should pre-allocated based on the Content-Length header value.<br />
                If true the body buffer is pre-allocated according to the size read from the Content-Length header. Otherwise, the body buffer is pre-allocated to 1KB, and is resized dynamically<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_BODY_PREALLOCATE_BODY_BUFFER
            </td>
            <td>boolean</td>
            <td>false</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.body.multipart.file-content-types</strong><br />
                A comma-separated list of ContentType to indicate whether a given multipart field should be handled as a file part. You can use this setting to force HTTP-based extensions to parse a message part as a file based on its
                content type. For now, this setting only works when using RESTEasy Reactive.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_BODY_MULTIPART_FILE_CONTENT_TYPES
            </td>
            <td>list of string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.auth.session.encryption-key</strong><br />
                The encryption key that is used to store persistent logins (e.g. for form auth). Logins are stored in a persistent cookie that is encrypted with AES-256 using a key derived from a SHA-256 hash of the key that is provided
                here. If no key is provided then an in-memory one will be generated, this will change on every restart though so it is not suitable for production environments. This must be more than 16 characters long for security reasons
                <br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_AUTH_SESSION_ENCRYPTION_KEY
            </td>
            <td>string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.so-reuse-port</strong><br />
                Enable socket reuse port (linux/macOs native transport only)<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SO_REUSE_PORT
            </td>
            <td>boolean</td>
            <td>false</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.tcp-quick-ack</strong><br />
                Enable tcp quick ack (linux native transport only)<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_TCP_QUICK_ACK
            </td>
            <td>boolean</td>
            <td>false</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.tcp-cork</strong><br />
                Enable tcp cork (linux native transport only)<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_TCP_CORK
            </td>
            <td>boolean</td>
            <td>false</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.tcp-fast-open</strong><br />
                Enable tcp fast open (linux native transport only)<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_TCP_FAST_OPEN
            </td>
            <td>boolean</td>
            <td>false</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.accept-backlog</strong><br />
                The accept backlog, this is how many connections can be waiting to be accepted before connections start being rejected<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_ACCEPT_BACKLOG
            </td>
            <td>int</td>
            <td>-1</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.domain-socket</strong><br />
                Path to a unix domain socket<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_DOMAIN_SOCKETc
            </td>
            <td>string</td>
            <td>/var/run/io.quarkus.app.socket</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.domain-socket-enabled</strong><br />
                Enable listening to host:port<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_DOMAIN_SOCKET_ENABLED
            </td>
            <td>boolean</td>
            <td>false</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.record-request-start-time</strong><br />
                If this is true then the request start time will be recorded to enable logging of total request time. This has a small performance penalty, so is disabled by default.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_RECORD_REQUEST_START_TIME
            </td>
            <td>boolean</td>
            <td>false</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.access-log.enabled</strong><br />
                If access logging is enabled. By default this will log via the standard logging facility<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_ACCESS_LOG_ENABLED
            </td>
            <td>boolean</td>
            <td>false</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.access-log.exclude-pattern</strong><br />
                A regular expression that can be used to exclude some paths from logging.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_ACCESS_LOG_EXCLUDE_PATTERN
            </td>
            <td>string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.access-log.pattern</strong><br />
                The access log pattern.<br />
                If this is the string common, combined or long then this will use one of the specified named formats:<br />
                common: %h %l %u %t "%r" %s %b<br />
                combined: %h %l %u %t "%r" %s %b "%{i,Referer}" "%{i,User-Agent}"<br />
                long: %r\n%{ALL_REQUEST_HEADERS}<br />
                Otherwise, consult the Quarkus documentation for the full list of variables that can be used.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_ACCESS_LOG_PATTERN
            </td>
            <td>string</td>
            <td>common</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.access-log.log-to-file</strong><br />
                If logging should be done to a separate file.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_ACCESS_LOG_LOG_TO_FILE
            </td>
            <td>boolean</td>
            <td>false</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.access-log.base-file-name</strong><br />
                The access log file base name, defaults to 'quarkus' which will give a log file name of 'quarkus.log'.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_ACCESS_LOG_BASE_FILE_NAME
            </td>
            <td>string</td>
            <td>quarkus</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.access-log.log-directory</strong><br />
                The log directory to use when logging access to a file If this is not set then the current working directory is used.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_ACCESS_LOG_LOG_DIRECTORY
            </td>
            <td>string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.access-log.log-suffix</strong><br />
                The log file suffix<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_ACCESS_LOG_LOG_SUFFIX
            </td>
            <td>string</td>
            <td>.log</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.access-log.category</strong><br />
                The log category to use if logging is being done via the standard log mechanism (i.e. if base-file-name is empty).<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_ACCESS_LOG_CATEGORY
            </td>
            <td>string</td>
            <td>io.quarkus.http.access-log</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.access-log.rotate</strong><br />
                If the log should be rotated daily<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_ACCESS_LOG_ROTATE
            </td>
            <td>boolean</td>
            <td>true</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.unhandled-error-content-type-default</strong><br />
                Provides a hint (optional) for the default content type of responses generated for the errors not handled by the application.<br />
                If the client requested a supported content-type in request headers (e.g. "Accept: application/json", "Accept: text/html"), Quarkus will use that content type.<br />
                Otherwise, it will default to the content type configured here.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_UNHANDLED_ERROR_CONTENT_TYPE_DEFAULT
            </td>
            <td>json, html</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.proxy.proxy-address-forwarding</strong><br />
                If this is true then the address, scheme etc. will be set from headers forwarded by the proxy server, such as X-Forwarded-For. This should only be set if you are behind a proxy that sets these headers.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_PROXY_PROXY_ADDRESS_FORWARDING
            </td>
            <td>boolean</td>
            <td>false</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.proxy.allow-forwarded</strong><br />
                If this is true and proxy address forwarding is enabled then the standard Forwarded header will be used. In case the not standard X-Forwarded-For header is enabled and detected on HTTP requests, the standard header has the
                precedence. Activating this together with quarkus.http.proxy.allow-x-forwarded has security implications as clients can forge requests with a forwarded header that is not overwritten by the proxy. Therefore, proxies should
                strip unexpected X-Forwarded or X-Forwarded-* headers from the client.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_PROXY_ALLOW_FORWARDED
            </td>
            <td>boolean</td>
            <td>false</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.proxy.allow-x-forwarded</strong><br />
                If either this or allow-forwarded are true and proxy address forwarding is enabled then the not standard Forwarded header will be used. In case the standard Forwarded header is enabled and detected on HTTP requests, the
                standard header has the precedence. Activating this together with quarkus.http.proxy.allow-x-forwarded has security implications as clients can forge requests with a forwarded header that is not overwritten by the proxy.
                Therefore, proxies should strip unexpected X-Forwarded or X-Forwarded-* headers from the client.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_PROXY_ALLOW_X_FORWARDED
            </td>
            <td>boolean</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.proxy.enable-forwarded-host</strong><br />
                Enable override the received request’s host through a forwarded host header.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_PROXY_ENABLE_FORWARDED_HOST
            </td>
            <td>boolean</td>
            <td>false</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.proxy.forwarded-host-header</strong><br />
                Configure the forwarded host header to be used if override enabled.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_PROXY_FORWARDED_HOST_HEADER
            </td>
            <td>string</td>
            <td>X-Forwarded-Host</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.proxy.enable-forwarded-prefix</strong><br />
                Enable prefix the received request’s path with a forwarded prefix header.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_PROXY_ENABLE_FORWARDED_PREFIX
            </td>
            <td>boolean</td>
            <td>false</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.proxy.forwarded-prefix-header</strong><br />
                Configure the forwarded prefix header to be used if prefixing enabled.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_PROXY_FORWARDED_PREFIX_HEADER
            </td>
            <td>string</td>
            <td>X-Forwarded-Prefix</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.same-site-cookie."same-site-cookie".case-sensitive</strong><br />
                If the cookie pattern is case-sensitive<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SAME_SITE_COOKIE__SAME_SITE_COOKIE__CASE_SENSITIVE
            </td>
            <td>boolean</td>
            <td>false</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.same-site-cookie."same-site-cookie".value</strong><br />
                The value to set in the samesite attribute<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SAME_SITE_COOKIE__SAME_SITE_COOKIE__VALUE
            </td>
            <td>none, strict, lax</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.same-site-cookie."same-site-cookie".enable-client-checker</strong><br />
                Some User Agents break when sent SameSite=None, this will detect them and avoid sending the value<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SAME_SITE_COOKIE__SAME_SITE_COOKIE__ENABLE_CLIENT_CHECKER
            </td>
            <td>boolean</td>
            <td>true</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.same-site-cookie."same-site-cookie".add-secure-for-none</strong><br />
                If this is true then the 'secure' attribute will automatically be sent on cookies with a SameSite attribute of None.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SAME_SITE_COOKIE__SAME_SITE_COOKIE__ADD_SECURE_FOR_NONE
            </td>
            <td>boolean</td>
            <td>true</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.header."header".path</strong><br />
                The path this header should be applied<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_HEADER__HEADER__PATH
            </td>
            <td>string</td>
            <td>/*</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.header."header".value</strong><br />
                The value for this header configuration<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_HEADER__HEADER__VALUE
            </td>
            <td>string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.header."header".methods</strong><br />
                The HTTP methods for this header configuration<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_HEADER__HEADER__METHODS
            </td>
            <td>list of string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.filter."filter".matches</strong><br />
                A regular expression for the paths matching this configuration<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_FILTER__FILTER__MATCHES
            </td>
            <td>string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.filter."filter".header</strong><br />
                Additional HTTP Headers always sent in the response<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_FILTER__FILTER__HEADER
            </td>
            <td>Map&lt;String,String&gt;</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.filter."filter".methods</strong><br />
                The HTTP methods for this path configuration<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_FILTER__FILTER__METHODS
            </td>
            <td>list of string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.filter."filter".order</strong><br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_FILTER__FILTER__ORDER
            </td>
            <td>int</td>
            <td></td>
        </tr>
    </tbody>
</table>

Quarkus also provides a ton of flags to customize the application behaviour. These are some of the flags that are most commonly used.

<table>
    <thead>
        <tr>
            <th>Configuration property</th>
            <th>Type</th>
            <th>Default</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>
                <strong>quarkus.http.cors</strong><br />
                Enable the CORS filter.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_CORS
            </td>
            <td>boolean</td>
            <td>false</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.port</strong><br />
                The HTTP port<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_PORT
            </td>
            <td>int</td>
            <td>8080</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.test-port</strong><br />
                The HTTP port used to run tests<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_TEST_PORT
            </td>
            <td>int</td>
            <td>8081</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.host</strong><br />
                The HTTP host In dev/test mode this defaults to localhost, in prod mode this defaults to 0.0.0.0 Defaulting to 0.0.0.0 makes it easier to deploy Quarkus to container, however it is not suitable for dev/test mode as other
                people on the network can connect to your development machine.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_HOST
            </td>
            <td>string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.host-enabled</strong><br />
                Enable listening to host:port<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_HOST_ENABLED
            </td>
            <td>boolean</td>
            <td>true</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.ssl-port</strong><br />
                The HTTPS port<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SSL_PORT
            </td>
            <td>int</td>
            <td>8443</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.test-ssl-port</strong><br />
                The HTTPS port used to run tests<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_TEST_SSL_PORT
            </td>
            <td>int</td>
            <td>8444</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.insecure-requests</strong><br />
                If insecure (i.e. http rather than https) requests are allowed. If this is enabled then http works as normal. redirect will still open the http port, but all requests will be redirected to the HTTPS port. disabled will
                prevent the HTTP port from opening at all.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_INSECURE_REQUESTS
            </td>
            <td>enabled, redirect, disabled</td>
            <td>enabled</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.http2</strong><br />
                If this is true (the default) then HTTP/2 will be enabled. Note that for browsers to be able to use it HTTPS must be enabled, and you must be running on JDK11 or above, as JDK8 does not support ALPN.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_HTTP2
            </td>
            <td>boolean</td>
            <td>true</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.cors.origins</strong><br />
                Origins allowed for CORS Comma separated list of valid URLs, e.g.: <a href="http://www.quarkus.io,http://localhost:3000" rel="nofollow">http://www.quarkus.io,http://localhost:3000</a> In case an entry of the list is
                surrounded by forward slashes, it is interpreted as a regular expression.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_CORS_ORIGINS
            </td>
            <td>list of string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.cors.methods</strong><br />
                HTTP methods allowed for CORS Comma separated list of valid methods. ex: GET,PUT,POST The filter allows any method if this is not set. default: returns any requested method as valid<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_CORS_METHODS
            </td>
            <td>list of string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.cors.headers</strong><br />
                HTTP headers allowed for CORS Comma separated list of valid headers. ex: X-Custom,Content-Disposition The filter allows any header if this is not set. default: returns any requested header as valid<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_CORS_HEADERS
            </td>
            <td>list of string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.cors.exposed-headers</strong><br />
                HTTP headers exposed in CORS Comma separated list of valid headers. ex: X-Custom,Content-Disposition default: empty<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_CORS_EXPOSED_HEADERS
            </td>
            <td>list of string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.cors.access-control-max-age</strong><br />
                The Access-Control-Max-Age response header value indicating how long the results of a pre-flight request can be cached.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_CORS_ACCESS_CONTROL_MAX_AGE
            </td>
            <td>Duration</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.cors.access-control-allow-credentials</strong><br />
                The Access-Control-Allow-Credentials header is used to tell the browsers to expose the response to front-end JavaScript code when the request’s credentials mode Request.credentials is “include”. The value of this header will
                default to true if quarkus.http.cors.origins property is set and there is a match with the precise Origin header and that header is not '*'.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_CORS_ACCESS_CONTROL_ALLOW_CREDENTIALS
            </td>
            <td>boolean</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.ssl.certificate.credentials-provider</strong><br />
                The CredentialsProvider. If this property is configured then a matching 'CredentialsProvider' will be used to get the keystore, keystore key and truststore passwords unless these passwords have already been configured.
                Please note that using MicroProfile ConfigSource which is directly supported by Quarkus Configuration should be preferred unless using CredentialsProvider provides for some additional security and dynamism.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SSL_CERTIFICATE_CREDENTIALS_PROVIDER
            </td>
            <td>string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.ssl.certificate.credentials-provider-name</strong><br />
                The credentials provider bean name.<br />
                It is the &amp;#64;Named value of the credentials provider bean. It is used to discriminate if multiple CredentialsProvider beans are available. It is recommended to set this property even if there is only one credentials
                provider currently available to ensure the same provider is always found in deployments where more than one provider may be available.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SSL_CERTIFICATE_CREDENTIALS_PROVIDER_NAME
            </td>
            <td>string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.ssl.certificate.files</strong><br />
                The list of path to server certificates using the PEM format. Specifying multiple files require SNI to be enabled.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SSL_CERTIFICATE_FILES
            </td>
            <td>list of path</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.ssl.certificate.key-files</strong><br />
                The list of path to server certificates private key file using the PEM format. Specifying multiple files require SNI to be enabled. The order of the key files must match the order of the certificates.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SSL_CERTIFICATE_KEY_FILES
            </td>
            <td>list of path</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.ssl.certificate.key-store-file</strong><br />
                An optional key store which holds the certificate information instead of specifying separate files.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SSL_CERTIFICATE_KEY_STORE_FILE
            </td>
            <td>path</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.ssl.certificate.key-store-file-type</strong><br />
                An optional parameter to specify type of the key store file. If not given, the type is automatically detected based on the file name.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SSL_CERTIFICATE_KEY_STORE_FILE_TYPE
            </td>
            <td>string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.ssl.certificate.key-store-provider</strong><br />
                An optional parameter to specify a provider of the key store file. If not given, the provider is automatically detected based on the key store file type.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SSL_CERTIFICATE_KEY_STORE_PROVIDER
            </td>
            <td>string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.ssl.certificate.key-store-password</strong><br />
                A parameter to specify the password of the key store file. If not given, and if it can not be retrieved from CredentialsProvider, then the default ("password") is used.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SSL_CERTIFICATE_KEY_STORE_PASSWORD
            </td>
            <td>string</td>
            <td>password</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.ssl.certificate.key-store-password-key</strong><br />
                A parameter to specify a CredentialsProvider property key which can be used to get the password of the key store file from CredentialsProvider.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SSL_CERTIFICATE_KEY_STORE_PASSWORD_KEY
            </td>
            <td>string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.ssl.certificate.key-store-key-alias</strong><br />
                An optional parameter to select a specific key in the key store. When SNI is disabled, if the key store contains multiple keys and no alias is specified, the behavior is undefined.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SSL_CERTIFICATE_KEY_STORE_KEY_ALIAS
            </td>
            <td>string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.ssl.certificate.key-store-key-password</strong><br />
                An optional parameter to define the password for the key, in case it’s different from key-store-password If not given then it may be retrieved from CredentialsProvider.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SSL_CERTIFICATE_KEY_STORE_KEY_PASSWORD
            </td>
            <td>string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.ssl.certificate.key-store-key-password-key</strong><br />
                A parameter to specify a CredentialsProvider property key which can be used to get the password for the key from CredentialsProvider.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SSL_CERTIFICATE_KEY_STORE_KEY_PASSWORD_KEY
            </td>
            <td>string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.ssl.certificate.trust-store-file</strong><br />
                An optional trust store which holds the certificate information of the certificates to trust.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SSL_CERTIFICATE_TRUST_STORE_FILE
            </td>
            <td>path</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.ssl.certificate.trust-store-file-type</strong><br />
                An optional parameter to specify type of the trust store file. If not given, the type is automatically detected based on the file name.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SSL_CERTIFICATE_TRUST_STORE_FILE_TYPE
            </td>
            <td>string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.ssl.certificate.trust-store-provider</strong><br />
                An optional parameter to specify a provider of the trust store file. If not given, the provider is automatically detected based on the trust store file type.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SSL_CERTIFICATE_TRUST_STORE_PROVIDER
            </td>
            <td>string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.ssl.certificate.trust-store-password</strong><br />
                A parameter to specify the password of the trust store file. If not given then it may be retrieved from CredentialsProvider.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SSL_CERTIFICATE_TRUST_STORE_PASSWORD
            </td>
            <td>string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.ssl.certificate.trust-store-password-key</strong><br />
                A parameter to specify a CredentialsProvider property key which can be used to get the password of the trust store file from CredentialsProvider.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SSL_CERTIFICATE_TRUST_STORE_PASSWORD_KEY
            </td>
            <td>string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.ssl.certificate.trust-store-cert-alias</strong><br />
                An optional parameter to trust only one specific certificate in the trust store (instead of trusting all certificates in the store).<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SSL_CERTIFICATE_TRUST_STORE_CERT_ALIAS
            </td>
            <td>string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.ssl.cipher-suites</strong><br />
                The cipher suites to use. If none is given, a reasonable default is selected.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SSL_CIPHER_SUITES
            </td>
            <td>list of string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.ssl.protocols</strong><br />
                The list of protocols to explicitly enable.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SSL_PROTOCOLS
            </td>
            <td>list of string</td>
            <td>TLSv1.3,TLSv1.2</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.ssl.sni</strong><br />
                Enables Server Name Indication (SNI), an TLS extension allowing the server to use multiple certificates. The client indicate the server name during the TLS handshake, allowing the server to select the right certificate.
                <br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SSL_SNI
            </td>
            <td>boolean</td>
            <td>false</td>
        </tr>
        <tr>
            <td>
                **quarkus.http.static-resources.index-page&lt;**br/&gt;Set the index page when serving static resources.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_STATIC_RESOURCES_INDEX_PAGE
            </td>
            <td>string</td>
            <td>index.html</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.static-resources.include-hidden</strong><br />
                Set whether hidden files should be served.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_STATIC_RESOURCES_INCLUDE_HIDDEN
            </td>
            <td>boolean</td>
            <td>true</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.static-resources.enable-range-support</strong><br />
                Set whether range requests (resumable downloads; media streaming) should be enabled.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_STATIC_RESOURCES_ENABLE_RANGE_SUPPORT
            </td>
            <td>boolean</td>
            <td>true</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.static-resources.caching-enabled</strong><br />
                Set whether cache handling is enabled.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_STATIC_RESOURCES_CACHING_ENABLED
            </td>
            <td>boolean</td>
            <td>true</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.static-resources.cache-entry-timeout</strong><br />
                Set the cache entry timeout. The default is 30 seconds.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_STATIC_RESOURCES_CACHE_ENTRY_TIMEOUT
            </td>
            <td>Duration</td>
            <td>30S</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.static-resources.max-age</strong><br />
                Set value for max age in caching headers. The default is 24 hours.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_STATIC_RESOURCES_MAX_AGE
            </td>
            <td>Duration</td>
            <td>24H</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.static-resources.max-cache-size</strong><br />
                Set the max cache size.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_STATIC_RESOURCES_MAX_CACHE_SIZE
            </td>
            <td>int</td>
            <td>10000</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.handle-100-continue-automatically</strong><br />
                When set to true, the HTTP server automatically sends 100 CONTINUE response when the request expects it (with the Expect: 100-Continue header).<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_HANDLE_100_CONTINUE_AUTOMATICALLY
            </td>
            <td>boolean</td>
            <td>false</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.io-threads</strong><br />
                The number if IO threads used to perform IO. This will be automatically set to a reasonable value based on the number of CPU cores if it is not provided. If this is set to a higher value than the number of Vert.x event loops
                then it will be capped at the number of event loops. In general this should be controlled by setting quarkus.vertx.event-loops-pool-size, this setting should only be used if you want to limit the number of HTTP io threads to
                a smaller number than the total number of IO threads.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_IO_THREADS
            </td>
            <td>int</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.limits.max-header-size</strong><br />
                The maximum length of all headers.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_LIMITS_MAX_HEADER_SIZE
            </td>
            <td>MemorySize</td>
            <td>20K</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.limits.max-body-size</strong><br />
                The maximum size of a request body.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_LIMITS_MAX_BODY_SIZE
            </td>
            <td>MemorySize</td>
            <td>10240K</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.limits.max-chunk-size</strong><br />
                The max HTTP chunk size<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_LIMITS_MAX_CHUNK_SIZE
            </td>
            <td>MemorySize</td>
            <td>8192</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.limits.max-initial-line-length</strong><br />
                The maximum length of the initial line (e.g. "GET / HTTP/1.0").<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_LIMITS_MAX_INITIAL_LINE_LENGTH
            </td>
            <td>int</td>
            <td>4096</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.limits.max-form-attribute-size</strong><br />
                The maximum length of a form attribute.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_LIMITS_MAX_FORM_ATTRIBUTE_SIZE
            </td>
            <td>MemorySize</td>
            <td>2048</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.limits.max-connections</strong><br />
                The maximum number of connections that are allowed at any one time. If this is set it is recommended to set a short idle timeout.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_LIMITS_MAX_CONNECTIONS
            </td>
            <td>int</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.idle-timeout</strong><br />
                Http connection idle timeout<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_IDLE_TIMEOUT
            </td>
            <td>Duration</td>
            <td>30M</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.read-timeout</strong><br />
                Http connection read timeout for blocking IO. This is the maximum amount of time a thread will wait for data, before an IOException will be thrown and the connection closed.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_READ_TIMEOUT
            </td>
            <td>Duration</td>
            <td>60S</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.body.handle-file-uploads</strong><br />
                Whether the files sent using multipart/form-data will be stored locally.<br />
                <br />
                If true, they will be stored in quarkus.http.body-handler.uploads-directory and will be made available via io.vertx.ext.web.RoutingContext.fileUploads(). Otherwise, the files sent using multipart/form-data will not be stored
                locally, and io.vertx.ext.web.RoutingContext.fileUploads() will always return an empty collection. Note that even with this option being set to false, the multipart/form-data requests will be accepted.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_BODY_HANDLE_FILE_UPLOADS
            </td>
            <td>boolean</td>
            <td>true</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.body.uploads-directory</strong><br />
                The directory where the files sent using multipart/form-data should be stored.<br />
                Either an absolute path or a path relative to the current directory of the application process.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_BODY_UPLOADS_DIRECTORY
            </td>
            <td>string</td>
            <td>${java.io.tmpdir}/uploads</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.body.merge-form-attributes</strong><br />
                Whether the form attributes should be added to the request parameters.<br />
                If true, the form attributes will be added to the request parameters; otherwise the form parameters will not be added to the request parameters<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_BODY_MERGE_FORM_ATTRIBUTES
            </td>
            <td>boolean</td>
            <td>true</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.body.delete-uploaded-files-on-end</strong><br />
                Whether the uploaded files should be removed after serving the request.<br />
                If true the uploaded files stored in quarkus.http.body-handler.uploads-directory will be removed after handling the request. Otherwise, the files will be left there forever.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_BODY_DELETE_UPLOADED_FILES_ON_END
            </td>
            <td>boolean</td>
            <td>true</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.body.preallocate-body-buffer</strong><br />
                Whether the body buffer should pre-allocated based on the Content-Length header value.<br />
                If true the body buffer is pre-allocated according to the size read from the Content-Length header. Otherwise, the body buffer is pre-allocated to 1KB, and is resized dynamically<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_BODY_PREALLOCATE_BODY_BUFFER
            </td>
            <td>boolean</td>
            <td>false</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.body.multipart.file-content-types</strong><br />
                A comma-separated list of ContentType to indicate whether a given multipart field should be handled as a file part. You can use this setting to force HTTP-based extensions to parse a message part as a file based on its
                content type. For now, this setting only works when using RESTEasy Reactive.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_BODY_MULTIPART_FILE_CONTENT_TYPES
            </td>
            <td>list of string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.auth.session.encryption-key</strong><br />
                The encryption key that is used to store persistent logins (e.g. for form auth). Logins are stored in a persistent cookie that is encrypted with AES-256 using a key derived from a SHA-256 hash of the key that is provided
                here. If no key is provided then an in-memory one will be generated, this will change on every restart though so it is not suitable for production environments. This must be more than 16 characters long for security reasons
                <br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_AUTH_SESSION_ENCRYPTION_KEY
            </td>
            <td>string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.so-reuse-port</strong><br />
                Enable socket reuse port (linux/macOs native transport only)<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SO_REUSE_PORT
            </td>
            <td>boolean</td>
            <td>false</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.tcp-quick-ack</strong><br />
                Enable tcp quick ack (linux native transport only)<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_TCP_QUICK_ACK
            </td>
            <td>boolean</td>
            <td>false</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.tcp-cork</strong><br />
                Enable tcp cork (linux native transport only)<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_TCP_CORK
            </td>
            <td>boolean</td>
            <td>false</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.tcp-fast-open</strong><br />
                Enable tcp fast open (linux native transport only)<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_TCP_FAST_OPEN
            </td>
            <td>boolean</td>
            <td>false</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.accept-backlog</strong><br />
                The accept backlog, this is how many connections can be waiting to be accepted before connections start being rejected<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_ACCEPT_BACKLOG
            </td>
            <td>int</td>
            <td>-1</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.domain-socket</strong><br />
                Path to a unix domain socket<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_DOMAIN_SOCKETc
            </td>
            <td>string</td>
            <td>/var/run/io.quarkus.app.socket</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.domain-socket-enabled</strong><br />
                Enable listening to host:port<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_DOMAIN_SOCKET_ENABLED
            </td>
            <td>boolean</td>
            <td>false</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.record-request-start-time</strong><br />
                If this is true then the request start time will be recorded to enable logging of total request time. This has a small performance penalty, so is disabled by default.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_RECORD_REQUEST_START_TIME
            </td>
            <td>boolean</td>
            <td>false</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.access-log.enabled</strong><br />
                If access logging is enabled. By default this will log via the standard logging facility<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_ACCESS_LOG_ENABLED
            </td>
            <td>boolean</td>
            <td>false</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.access-log.exclude-pattern</strong><br />
                A regular expression that can be used to exclude some paths from logging.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_ACCESS_LOG_EXCLUDE_PATTERN
            </td>
            <td>string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.access-log.pattern</strong><br />
                The access log pattern.<br />
                If this is the string common, combined or long then this will use one of the specified named formats:<br />
                common: %h %l %u %t "%r" %s %b<br />
                combined: %h %l %u %t "%r" %s %b "%{i,Referer}" "%{i,User-Agent}"<br />
                long: %r\n%{ALL_REQUEST_HEADERS}<br />
                Otherwise, consult the Quarkus documentation for the full list of variables that can be used.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_ACCESS_LOG_PATTERN
            </td>
            <td>string</td>
            <td>common</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.access-log.log-to-file</strong><br />
                If logging should be done to a separate file.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_ACCESS_LOG_LOG_TO_FILE
            </td>
            <td>boolean</td>
            <td>false</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.access-log.base-file-name</strong><br />
                The access log file base name, defaults to 'quarkus' which will give a log file name of 'quarkus.log'.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_ACCESS_LOG_BASE_FILE_NAME
            </td>
            <td>string</td>
            <td>quarkus</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.access-log.log-directory</strong><br />
                The log directory to use when logging access to a file If this is not set then the current working directory is used.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_ACCESS_LOG_LOG_DIRECTORY
            </td>
            <td>string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.access-log.log-suffix</strong><br />
                The log file suffix<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_ACCESS_LOG_LOG_SUFFIX
            </td>
            <td>string</td>
            <td>.log</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.access-log.category</strong><br />
                The log category to use if logging is being done via the standard log mechanism (i.e. if base-file-name is empty).<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_ACCESS_LOG_CATEGORY
            </td>
            <td>string</td>
            <td>io.quarkus.http.access-log</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.access-log.rotate</strong><br />
                If the log should be rotated daily<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_ACCESS_LOG_ROTATE
            </td>
            <td>boolean</td>
            <td>true</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.unhandled-error-content-type-default</strong><br />
                Provides a hint (optional) for the default content type of responses generated for the errors not handled by the application.<br />
                If the client requested a supported content-type in request headers (e.g. "Accept: application/json", "Accept: text/html"), Quarkus will use that content type.<br />
                Otherwise, it will default to the content type configured here.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_UNHANDLED_ERROR_CONTENT_TYPE_DEFAULT
            </td>
            <td>json, html</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.proxy.proxy-address-forwarding</strong><br />
                If this is true then the address, scheme etc. will be set from headers forwarded by the proxy server, such as X-Forwarded-For. This should only be set if you are behind a proxy that sets these headers.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_PROXY_PROXY_ADDRESS_FORWARDING
            </td>
            <td>boolean</td>
            <td>false</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.proxy.allow-forwarded</strong><br />
                If this is true and proxy address forwarding is enabled then the standard Forwarded header will be used. In case the not standard X-Forwarded-For header is enabled and detected on HTTP requests, the standard header has the
                precedence. Activating this together with quarkus.http.proxy.allow-x-forwarded has security implications as clients can forge requests with a forwarded header that is not overwritten by the proxy. Therefore, proxies should
                strip unexpected X-Forwarded or X-Forwarded-* headers from the client.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_PROXY_ALLOW_FORWARDED
            </td>
            <td>boolean</td>
            <td>false</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.proxy.allow-x-forwarded</strong><br />
                If either this or allow-forwarded are true and proxy address forwarding is enabled then the not standard Forwarded header will be used. In case the standard Forwarded header is enabled and detected on HTTP requests, the
                standard header has the precedence. Activating this together with quarkus.http.proxy.allow-x-forwarded has security implications as clients can forge requests with a forwarded header that is not overwritten by the proxy.
                Therefore, proxies should strip unexpected X-Forwarded or X-Forwarded-* headers from the client.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_PROXY_ALLOW_X_FORWARDED
            </td>
            <td>boolean</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.proxy.enable-forwarded-host</strong><br />
                Enable override the received request’s host through a forwarded host header.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_PROXY_ENABLE_FORWARDED_HOST
            </td>
            <td>boolean</td>
            <td>false</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.proxy.forwarded-host-header</strong><br />
                Configure the forwarded host header to be used if override enabled.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_PROXY_FORWARDED_HOST_HEADER
            </td>
            <td>string</td>
            <td>X-Forwarded-Host</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.proxy.enable-forwarded-prefix</strong><br />
                Enable prefix the received request’s path with a forwarded prefix header.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_PROXY_ENABLE_FORWARDED_PREFIX
            </td>
            <td>boolean</td>
            <td>false</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.proxy.forwarded-prefix-header</strong><br />
                Configure the forwarded prefix header to be used if prefixing enabled.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_PROXY_FORWARDED_PREFIX_HEADER
            </td>
            <td>string</td>
            <td>X-Forwarded-Prefix</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.same-site-cookie."same-site-cookie".case-sensitive</strong><br />
                If the cookie pattern is case-sensitive<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SAME_SITE_COOKIE__SAME_SITE_COOKIE__CASE_SENSITIVE
            </td>
            <td>boolean</td>
            <td>false</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.same-site-cookie."same-site-cookie".value</strong><br />
                The value to set in the samesite attribute<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SAME_SITE_COOKIE__SAME_SITE_COOKIE__VALUE
            </td>
            <td>none, strict, lax</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.same-site-cookie."same-site-cookie".enable-client-checker</strong><br />
                Some User Agents break when sent SameSite=None, this will detect them and avoid sending the value<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SAME_SITE_COOKIE__SAME_SITE_COOKIE__ENABLE_CLIENT_CHECKER
            </td>
            <td>boolean</td>
            <td>true</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.same-site-cookie."same-site-cookie".add-secure-for-none</strong><br />
                If this is true then the 'secure' attribute will automatically be sent on cookies with a SameSite attribute of None.<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_SAME_SITE_COOKIE__SAME_SITE_COOKIE__ADD_SECURE_FOR_NONE
            </td>
            <td>boolean</td>
            <td>true</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.header."header".path</strong><br />
                The path this header should be applied<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_HEADER__HEADER__PATH
            </td>
            <td>string</td>
            <td>/*</td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.header."header".value</strong><br />
                The value for this header configuration<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_HEADER__HEADER__VALUE
            </td>
            <td>string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.header."header".methods</strong><br />
                The HTTP methods for this header configuration<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_HEADER__HEADER__METHODS
            </td>
            <td>list of string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.filter."filter".matches</strong><br />
                A regular expression for the paths matching this configuration<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_FILTER__FILTER__MATCHES
            </td>
            <td>string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.filter."filter".header</strong><br />
                Additional HTTP Headers always sent in the response<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_FILTER__FILTER__HEADER
            </td>
            <td>Map&lt;String,String&gt;</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.filter."filter".methods</strong><br />
                The HTTP methods for this path configuration<br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_FILTER__FILTER__METHODS
            </td>
            <td>list of string</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <strong>quarkus.http.filter."filter".order</strong><br />
                <strong>Environment variable:</strong> QUARKUS_HTTP_FILTER__FILTER__ORDER
            </td>
            <td>int</td>
            <td></td>
        </tr>
    </tbody>
</table>


The complete list of quarkus flag is available [here](https://quarkus.io/guides/all-config).
