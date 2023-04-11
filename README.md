# sonhtCellPhoneShop
Đây là trang web bán hàng sử dụng công nghệ JSP, Servlet.

Project được phát triển trên phiên bản Eclipse developersEclipse IDE 2022-09.
Vui lòng cài đặt phiên bản tomcat 9.0.68.
Xem hướng dẫn tại đây : https://huongdanjava.com/vi/cai-dat-tomcat-trong-eclipse.html

Database được tạo bằng MS SQL Server
Vui lòng cài đặt phiên bản Microsoft SQL Server 2019 (RTM-GDR) (KB5021125) - 15.0.2101.7 (X64).
Xem hướng dẫn tại đây : https://quantrimang.com/cong-nghe/cai-dat-sql-server-2019-159201

File sql được đính kèm trong project tên là ShoppingDBASM4.sql.

A. Mô tả ứng dụng

Bước đầu tiên là thiết kế cơ sở dữ liệu của project.


Lưu ý về lỗi kết nối cơ sở dữ liệu

1. Trên console của Eclipse/IntelliJ IDEA có lỗi sau:

javax.servlet.jsp.JspException: Unable to get connection, DataSource invalid: "java.sql.SQLException: Cannot create PoolableConnectionFactory (The TCP/IP connection to the host DESKTOP-JF0IAR2, port 1433 has failed. Error: "Connect timed out. Verify the connection properties. Make sure that an instance of SQL Server is running on the host and accepting TCP/IP connections at the port. Make sure that TCP connections to the port are not blocked by a firewall.".)"

Gợi ý xử lý lỗi: Lỗi này do cấu hình của sql server chưa mở port 1433. Tùy version của SQL server mà có các cách xử lí khác nhau.

Học viên tham khảo link sau: https://docs.microsoft.com/en-us/sql/database-engine/configure-windows/configure-a-server-to-listen-on-a-specific-tcp-port?view=sql-server-ver16

2. Trên console của Eclipse/IntelliJ IDEA có lỗi sau:

Caused by: com.microsoft.sqlserver.jdbc.SQLServerException: Login failed for user 'sa'. ClientConnectionId:4a1fb7ab-3f5e-4808-a645-466752c1f4b0

Gợi ý xử lý lỗi: Lỗi này có thể do password của account sa bị sai hoặc chưa enable sa account. Bạn cần kiểm tra source code đã dùng đúng password của sa chưa.

Để enable sa account, học viên tham khảo link sau: https://docs.microsoft.com/en-us/sql/database-engine/configure-windows/change-server-authentication-mode?view=sql-server-ver16.

Các tính năng chính của chương trình được giới thiệu trong video demo tại đây : https://www.youtube.com/watch?v=IhExq2VoQUM

Cảm ơn đã theo dõi & follow để xem nhiều source code hơn.

