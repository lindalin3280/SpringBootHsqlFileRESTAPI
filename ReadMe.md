API to upload a file with a few meta-data fields. Persist meta-data in persistence store (In memory DB or file system and store the content on a file system)<br />
http://127.0.0.1:8080/file/upload<br />
Example: Run UploadAndQueryAPITest.java<br />
Response example:<br />
{"statusType":"OK","entity":[],"entityType":"java.util.ArrayList","status":200,"metadata":{}}<br />
{"statusType":"OK","entity":{"fileId":1,"userId":"tester","fileName":"demo.txt","path":"C:\\Users\\Jie\\git\\demo\\rest-demo\\uploaded\\demo.txt1496547429039","uploadTime":"2017-06-03 22:37:09"},"entityType":"org.linda.restdemo.entity.FileMetadata","status":200,"metadata":{}}<br />

We can test if file being uploaded successfully by searching file by file id:<br />
http://localhost:8080/file/query?fileId=1<br />
Response example:<br />
{"statusType":"OK","entity":{"fileId":1,"userId":"tester","fileName":"demo.txt","path":"C:\\Users\\Jie\\git\\demo\\rest-demo\\uploaded\\demo.txt1496547429039","uploadTime":"2017-06-03 22:37:09"},"entityType":"org.linda.restdemo.entity.FileMetadata","status":200,"metadata":{}}<br />

We can test if file being uploaded successfully by searching file by file name:<br />
http://localhost:8080/file/query?fileName=demo.txt<br />
Response example:<br />
{"statusType":"OK","entity":[{"fileId":1,"userId":"tester","fileName":"demo.txt","path":"C:\\Users\\Jie\\git\\demo\\rest-demo\\uploaded\\demo.txt1496547429039","uploadTime":"2017-06-03 22:37:09"}],"entityType":"java.util.ArrayList","status":200,"metadata":{}}<br />


