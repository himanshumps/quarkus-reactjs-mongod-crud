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

### Work Directory for backend

`/home/default`

### Command to start the quarkus application

`mvn -Dquarkus.http.host=0.0.0.0 -Djava.util.logging.manager=org.jboss.logmanager.LogManager -Dmaven.test.skip quarkus:dev`
## Customization of the image using environment variable

The RedHat UBI image and the quarkus application provide a ton of flags to modify the application behaviour using environment variables.

The Java Runtime startup parameters that are available are as follows:

<table class="tableblock frame-all grid-all stretch table">
    <caption class="title"></caption>
    <colgroup>
        <col style="width: 33.3333%;">
        <col style="width: 33.3333%;">
        <col style="width: 33.3334%;">
    </colgroup>
    <thead>
        <tr>
            <th class="tableblock halign-left valign-top">Variable name</th>
            <th class="tableblock halign-left valign-top">Description</th>
            <th class="tableblock halign-left valign-top">Example value</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>AB_JOLOKIA_CONFIG</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">If set, uses this file, including path, as Jolokia JVM agent properties, as described in the Jolokia <a href="https://www.jolokia.org/reference/html/agents.html#agents-jvm">reference manual</a>. If not set, the <code>/opt/jolokia/etc/jolokia.properties</code> is created using the settings as defined in the manual. Otherwise, the rest of the settings in this document are ignored.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>/opt/jolokia/custom.properties</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>AB_JOLOKIA_DISCOVERY_ENABLED</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Enable Jolokia discovery. Defaults to <code>false</code>.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>true</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>AB_JOLOKIA_HOST</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Host address to bind to. Defaults to <code>0.0.0.0</code>.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>127.0.0.1</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>AB_JOLOKIA_ID</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Agent ID to use. Defaults to <code>$HOSTNAME</code>, which is the container ID.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>openjdk-app-1-xqlsj</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>AB_JOLOKIA_OFF</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">If set, disables activation of Jolokia, for example, echos an empty value. By default, Jolokia is enabled.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>true</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>AB_JOLOKIA_OPTS</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Additional options to be appended to the agent configuration. They should be given in the format <code>key=value,key=value,…&ZeroWidthSpace;</code>.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>backlog=20</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>AB_JOLOKIA_PASSWORD</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Password for basic authentication. By default, authentication is switched off.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>mypassword</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>AB_JOLOKIA_PORT</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Port to listen to. Defaults to <code>8778</code>.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>5432</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>AB_JOLOKIA_USER</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">User for basic authentication. Defaults to <code>jolokia</code>.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>myusername</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>AB_PROMETHEUS_ENABLE</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Enable the use of the Prometheus agent.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>true</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>AB_PROMETHEUS_JMX_EXPORTER_PORT</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Port to use for the Prometheus JMX Exporter.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>9799</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>CONTAINER_CORE_LIMIT</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">A calculated core limit as described in <a href="https://www.kernel.org/doc/Documentation/scheduler/sched-bwc.txt">CFS Bandwidth Control</a>.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>2</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>CONTAINER_MAX_MEMORY</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Memory limit given to the container.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>1024</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>GC_ADAPTIVE_SIZE_POLICY_WEIGHT</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">The weighting given to the current GC time versus previous GC times.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>90</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>GC_CONTAINER_OPTIONS</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Specify the Java GC to use. The value of this variable should contain the necessary JRE command-line interface options to specify the required GC, which overrides the default of <code>-XX:+UseParallelOldGC</code>.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>-XX:+UseG1GC</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>GC_MAX_HEAP_FREE_RATIO</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Maximum percentage of heap free after GC to avoid shrinking.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>40</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>GC_MAX_METASPACE_SIZE</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">The maximum metaspace size.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>100</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>GC_METASPACE_SIZE</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">The initial metaspace size.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>20</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>GC_MIN_HEAP_FREE_RATIO</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Minimum percentage of heap free after GC to avoid expansion.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>20</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>GC_TIME_RATIO</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Specifies the ratio of the time spent outside the garbage collection, for example, the time spent for application execution, to the time spent in the garbage collection.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>4</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>HTTPS_PROXY</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">The location of the https proxy. This takes precedence over <code>http_proxy</code> and <code>HTTP_PROXY</code>, and is used for both Maven builds and Java runtime.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>myuser@127.0.0.1:8080</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>HTTP_PROXY</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">The location of the http proxy. This is used for both Maven builds and Java runtime.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>127.0.0.1:8080</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>JAVA_APP_DIR</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">The directory where the application resides. All paths in your application are relative to this directory.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>myapplication/`</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>JAVA_ARGS</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Arguments passed to the <code>java</code> application.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">-</p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>JAVA_CLASSPATH</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">The classpath to use. If not given, the startup script checks for a file <code>JAVA_APP_DIR/classpath</code> and uses its content literally as classpath. If this file does not exist, all jars in the app dir are added. (<code>classes:JAVA_APP_DIR/*</code>).</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">-</p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>JAVA_DEBUG</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">If set, remote debugging is switched on. Disabled by default.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>true</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>JAVA_DEBUG_PORT</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Port used for remote debugging. Defaults to <code>5005</code>.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>8787</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>JAVA_DIAGNOSTICS</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Set this variable to get some diagnostics information to standard output when things are happening. Disabled by default.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>true</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>JAVA_INITIAL_MEM_RATIO</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Used when no <code>-Xms</code> option is given in <code>JAVA_OPTS</code>. This is used to calculate a default initial heap memory based on the maximum heap memory. If used in a container without any memory constraints for the container, this option has no effect. If there is a memory constraint, <code>-Xms</code> is set to a ratio of the <code>-Xmx</code> memory as set here. The default is <code>25</code> which means 25% of the <code>-Xmx</code> is used as the initial heap size. You can skip this mechanism by setting this value to <code>0</code>, in which case no <code>-Xms</code> option is added.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>25</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>JAVA_LIB_DIR</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Directory holding the Java jar files and an optional <code>classpath</code> file which holds the classpath as either a single line classpath (colon separated) or with jar files listed line-by-line. If not set, <code>JAVA_LIB_DIR</code> is the same as <code>JAVA_APP_DIR</code>.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">-</p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>JAVA_MAIN_CLASS</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">A main class to use as the argument for <code>java</code>. When this environment variable is given, all jar files in <code>JAVA_APP_DIR</code> are added to the classpath and <code>JAVA_LIB_DIR</code>.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>com.example.MainClass</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>JAVA_MAX_INITIAL_MEM</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Used when no <code>-Xms</code> option is given in <code>JAVA_OPTS</code>. This is used to calculate the maximum value of the initial heap memory. If used in a container without any memory constraints for the container, this option has no effect. If there is a memory constraint, <code>-Xms</code> is limited to the value set here. The default is <code>4096</code> MB, which means the calculated value of <code>-Xms</code> is never greater than 4096 MB. The value of this variable is expressed in MB.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>4096</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>JAVA_MAX_MEM_RATIO</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Used when no <code>-Xmx</code> option is given in <code>JAVA_OPTS</code>. This is used to calculate a default maximal heap memory based on a containers restriction. If used in a container without any memory constraints for the container, this option has no effect. If there is a memory constraint, <code>-Xmx</code> is set to a ratio of the container available memory as set here. The default is <code>50</code>, which means 50% of the available memory is used as an upper boundary. You can skip this mechanism by setting this value to <code>0</code>, in which case no <code>-Xmx</code> option is added.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">-</p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>JAVA_OPTS</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">JVM options passed to the <code>java</code> command.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>-verbose:class</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>JAVA_OPTS_APPEND</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">User specified Java options to be appended to generated options in <code>JAVA_OPTS</code>.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>-Dsome.property=foo</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>LOGGING_SCRIPT_DEBUG</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Set to <code>true</code> to enable script debugging. Deprecates <code>SCRIPT_DEBUG</code>.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>true</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>MAVEN_ARGS</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Arguments to use when calling Maven, replacing the default <code>package hawt-app:build -DskipTests -e</code>. Be sure to run the <code>hawt-app:build</code> goal when not already bound to the <code>package</code> execution phase, otherwise the startup scripts do not work.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>-e -Popenshift -DskipTests -Dcom.redhat.xpaas.repo.redhatga package</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>MAVEN_ARGS_APPEND</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Additional Maven arguments.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>-X -am -pl</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>MAVEN_CLEAR_REPO</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">If set, the Maven repository is removed after the artifact is built. This is useful for keeping the created application image small, but prevents incremental builds. This variable is overridden by <code>S2I_ENABLE_INCREMENTAL_BUILDS</code>. Defaults to <code>false</code>.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">-</p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>MAVEN_LOCAL_REPO</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Directory to use as the local Maven repository.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>/home/jboss/.m2/repository</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>MAVEN_MIRRORS</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">If set, multi-mirror support is enabled, and other <code>MAVEN_MIRROR_*</code> variables are prefixed. For example, <code>DEV_ONE_MAVEN_MIRROR_URL</code> and <code>QE_TWO_MAVEN_MIRROR_URL</code>.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>dev-one,qe-two</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>MAVEN_MIRROR_URL</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">The base URL of a mirror used for retrieving artifacts.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>http://10.0.0.1:8080/repository/internal/</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>MAVEN_REPOS</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">If set, multi-repo support is enabled, and other <code>MAVEN_REPO_*</code> variables are prefixed. For example, <code>DEV_ONE_MAVEN_REPO_URL</code> and <code>QE_TWO_MAVEN_REPO_URL</code>.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>dev-one,qe-two</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>MAVEN_S2I_ARTIFACT_DIRS</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Relative paths of source directories to scan for build output, which are copied to <code>DEPLOY_DIR</code>. Defaults to <code>target</code>.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>target</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>MAVEN_S2I_GOALS</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Space separated list of goals to be run with the maven build. For example, <code>mvn $MAVEN_S2I_GOALS</code>. Defaults to <code>package</code>.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>package install</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>MAVEN_SETTINGS_XML</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Location of custom Maven settings.xml file to use.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>/home/jboss/.m2/settings.xml</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>NO_PROXY</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">A comma separated list of hosts, IP addresses or domains that can be accessed directly. This is used for both Maven builds and Java runtime.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>foo.example.com,bar.example.com</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>S2I_ARTIFACTS_DIR</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Location mount for artifacts persisted with <code>save-artifacts</code> script, which are used with incremental builds. This must not be overridden by end users.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>${S2I_DESTINATION_DIR}/artifacts}</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>S2I_DESTINATION_DIR</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Root directory for S2I mount, as specified by the <code>io.openshift.s2i.destination</code> label. This must not be overridden by end users.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>/tmp</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>S2I_ENABLE_INCREMENTAL_BUILDS</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Do not remove source and intermediate build files so they can be saved for use with future builds. Defaults to <code>true</code>.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>true</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>S2I_IMAGE_SOURCE_MOUNTS</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Comma separated list of relative paths in the source directory which should be included in the image. The list can include wildcards, which are expanded using find. By default, the contents of mounted directories are processed similarly to source folders, where the contents of <code>S2I_SOURCE_CONFIGURATION_DIR</code>, <code>S2I_SOURCE_DATA_DIR</code>, and <code>S2I_SOURCE_DEPLOYMENTS_DIR</code> are copied to their respective target directories. Alternatively, if an <code>install.sh</code> file is located in the root of the mount point, it is executed instead. Deprecates <code>CUSTOM_INSTALL_DIRECTORIES</code>.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>extras/*</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>S2I_SOURCE_CONFIGURATION_DIR</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Relative path to directory containing application configuration files to be copied over to the product configuration directory, see <code>S2I_TARGET_CONFIGURATION_DIR</code>. Defaults to <code>configuration</code>.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>configuration</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>S2I_SOURCE_DATA_DIR</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Relative path to directory containing application data files to be copied over to the product data directory, see <code>S2I_TARGET_DATA_DIR</code>. Defaults to <code>data</code>.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>data</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>S2I_SOURCE_DEPLOYMENTS_DIR</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Relative path to directory containing binary files to be copied over to the product deployment directory, see <code>S2I_TARGET_DEPLOYMENTS_DIR</code>. Defaults to <code>deployments</code>.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>deployments</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>S2I_SOURCE_DIR</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Location of mount for source code to be built. This must not be overridden by end users.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>${S2I_DESTINATION_DIR}/src}</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>S2I_TARGET_CONFIGURATION_DIR</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Absolute path to which files located in <code>S2I_SOURCE_DIR</code>/<code>S2I_SOURCE_CONFIGURATION_DIR</code> are copied.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>/opt/eap/standalone/configuration</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>S2I_TARGET_DATA_DIR</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Absolute path to which files located in <code>S2I_SOURCE_DIR</code>/<code>S2I_SOURCE_DATA_DIR</code> are copied.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>/opt/eap/standalone/data</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>S2I_TARGET_DEPLOYMENTS_DIR</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Absolute path to which files located in <code>S2I_SOURCE_DIR</code>/<code>S2I_SOURCE_DEPLOYMENTS_DIR</code> are copied. Additionally, this is the directory to which build output is copied.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>/deployments</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>http_proxy</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">The location of the http proxy. This takes precedence over <code>HTTP_PROXY</code> and is used for both Maven builds and Java runtime.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>http://127.0.0.1:8080</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>https_proxy</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">The location of the https proxy. This takes precedence over <code>HTTPS_PROXY</code>, <code>http_proxy</code>, and <code>HTTP_PROXY</code>, and is used for both Maven builds and Java runtime.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>myuser:mypass@127.0.0.1:8080</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>no_proxy</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">A comma separated list of hosts, IP addresses or domains that can be accessed directly. This takes precedence over <code>NO_PROXY</code> and is used for both Maven builds and Java runtime.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>*.example.com</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>prefix_MAVEN_MIRROR_ID</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">ID to be used for the specified mirror. If omitted, a unique ID is generated.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>internal-mirror</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>prefix_MAVEN_MIRROR_OF</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Repository IDs mirrored by this entry. Defaults to <code>external:</code>.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">-</p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>prefix_MAVEN_MIRROR_URL</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">The URL of the mirror.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>http://10.0.0.1:8080/repository/internal</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>prefix_MAVEN_REPO_DIRECTORY_PERMISSIONS</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Maven repository directory permissions.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>775</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>prefix_MAVEN_REPO_FILE_PERMISSIONS</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Maven repository file permissions.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>664</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>prefix_MAVEN_REPO_HOST</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Maven repository host, if not using fully defined URL, falls back to service.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>repo.example.com</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>prefix_MAVEN_REPO_ID</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Maven repository ID.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>my-repo-id</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>prefix_MAVEN_REPO_LAYOUT</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Maven repository layout.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>default</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>prefix_MAVEN_REPO_NAME</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Maven repository name.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>my-repo-name</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>prefix_MAVEN_REPO_PASSPHRASE</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Maven repository passphrase.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>maven1!</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>prefix_MAVEN_REPO_PASSWORD</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Maven repository password.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>maven1!</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>prefix_MAVEN_REPO_PATH</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Maven repository path, if not using fully defined URL, falls back to service.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>/maven2/</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>prefix_MAVEN_REPO_PORT</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Maven repository port, if not using fully defined URL, falls back to service.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>8080</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>prefix_MAVEN_REPO_PRIVATE_KEY</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Maven repository private key.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>${user.home}/.ssh/id_dsa</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>prefix_MAVEN_REPO_PROTOCOL</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Maven repository protocol, if not using fully defined URL, falls back to service.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>http</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>prefix_MAVEN_REPO_RELEASES_CHECKSUM_POLICY</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Maven repository releases checksum policy.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>warn</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>prefix_MAVEN_REPO_RELEASES_ENABLED</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Maven repository releases enabled.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>true</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>prefix_MAVEN_REPO_RELEASES_UPDATE_POLICY</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Maven repository releases update policy.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>always</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>prefix_MAVEN_REPO_SERVICE</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Maven repository service to lookup if <code>prefix_MAVEN_REPO_URL</code> is not specified.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>buscentr-myapp</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>prefix_MAVEN_REPO_SNAPSHOTS_CHECKSUM_POLICY</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Maven repository snapshots checksum policy.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>warn</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>prefix_MAVEN_REPO_SNAPSHOTS_ENABLED</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Maven repository snapshots enabled.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>true</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>prefix_MAVEN_REPO_SNAPSHOTS_UPDATE_POLICY</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Maven repository snapshots update policy.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>always</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>prefix_MAVEN_REPO_URL</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Maven repository fully defined URL.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>http://repo.example.com:8080/maven2/</code></p>
            </td>
        </tr>
        <tr>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>prefix_MAVEN_REPO_USERNAME</code></p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock">Maven repository username.</p>
            </td>
            <td class="tableblock halign-left valign-top">
                <p class="tableblock"><code>mavenUser</code></p>
            </td>
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


The complete list for database configuration is available [here](https://quarkus.io/guides/datasource#datasource-reference)

The complete list of quarkus flag is available [here](https://quarkus.io/guides/all-config).
  

