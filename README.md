1. Chương trình khởi chạy trong FileMain:
    - Nhập tên file muốn đọc (src/text.txt hoặc một đường dẫn khác)
    - Nhập số lượng n dòng muốn đọc từ dưới lên trên
2. Xử lý đọc file
    - Class fileModel thể hiện 1 file gồm 3 thuộc tính:
        + url: Đường dẫn tới file
        + lengthOfCharacterOfLine: Số lượng ký tự tối đa trên 1 dòng (Đang để mặc định là 256)
        + lengOfCharacter: Là biến boolean để xét xem có cần yêu cầu về số lượng ký tự tối đa trên 1 dòng hay không.
            "true": Đọc 256 kí tự
            "false" Đọc vô hạn
        + Những lỗi có thể xảy ra:
            * Không tìm thấy file
            * Không đọc được file
            * File tồn tại dòng vượt quá số ký tự đã quy ước
3. Ý tưởng:
    - Sử dụng RandomAccessFile để chỉ con trỏ đọc file xuống cuối
    - Đọc kí tự theo thứ tự ngược lại
    - Nếu gặp dấu "enter" thì hiểu là hết một dòng
    - Cứ như vậy cho đủ n dòng thì dừng
