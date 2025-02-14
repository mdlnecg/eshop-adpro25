# Tutorial Pemrograman Lanjut
Madeline Clairine Gultom
2306207846
ADPRO-A

## Modul 1: Coding Standards
### Refleksi 1
> You already implemented two new features using Spring Boot. Check again your source code and evaluate the coding standards that you have learned in this module. Write clean code principles and secure coding practices that have been applied to your code.  If you find any mistake in your source code, please explain how to improve your code.

Melalui pengerjaan Exercise 1 dan Tutorial 1 pada mata kuliah Pemrograman Lanjut, saya telah menerapkan prinsip _clean code_ dengan menggunakan penamaan yang jelas dan deskriptif. Sebagai contoh, atribut dalam model `Product` diberi nama yang sesuai dengan fungsinya, seperti `productId`, `productName`, dan `productQuantity`. Selain itu, saya memastikan bahwa setiap fungsi diberi nama yang mencerminkan tugasnya, serta hanya menambahkan dokumentasi jika memang diperlukan. Saya juga menjaga konsistensi dalam indentasi dan format penulisan kode.

Namun, ada beberapa aspek yang masih dapat saya tingkatkan. Salah satu tantangan yang saya hadapi adalah ketika mengimplementasikan fitur edit produk. Saya mengalami kendala di mana produk tidak dapat diedit karena _productId_-nya bernilai _null_. Untuk mengatasi masalah ini, saya mencari solusi dan menemukan bahwa penggunaan UUID acak saat proses create product dapat mencegah kesalahan tersebut. Selain itu, saya menyadari bahwa logika penanganan kesalahan dalam kode saya masih dapat diperbaiki agar lebih optimal dan dapat meminimalisir kemungkinan terjadinya error.

### Refleksi 2
1. > After writing the unit test, how do you feel? How many unit tests should be made in a class? How to make sure that our unit tests are enough to verify our program? It would be good if you learned about code coverage. Code coverage is a metric that can help you understand how much of your source is tested. If you have 100% code coverage, does that mean your code has no bugs or errors?

Saya merasa bahwa unit test sangat membantu dalam memastikan bahwa kode berjalan sesuai dengan yang diharapkan. Dengan adanya unit test, programmer dapat lebih mudah mendeteksi dan mencegah potensi kesalahan tanpa harus menjalankan keseluruhan proyek secara manual berulang kali.

Jumlah unit test yang diperlukan dalam sebuah kelas bergantung pada kompleksitas dan kebutuhan dari proyek tersebut. Idealnya, setiap unit test sebaiknya menguji satu skenario atau kasus spesifik untuk menghindari redundansi dan memastikan cakupan pengujian yang lebih efektif.

Untuk memastikan bahwa *unit test* yang dibuat sudah cukup dalam memverifikasi program, kita dapat menggunakan *code coverage* sebagai metrik pengukuran. *Code coverage* dapat memberikan gambaran mengenai seberapa banyak bagian kode yang telah diuji oleh *unit test*. Namun, meskipun nilai *code coverage* mencapai 100%, kode belum tentu terbebas dari *bug* atau *error*. *Code coverage* hanya menunjukkan bahwa bagian kode tertentu telah dieksekusi dalam pengujian, tetapi tidak menjamin bahwa semua kemungkinan skenario telah diuji secara menyeluruh. Oleh karena itu, selain meningkatkan *code coverage*, tetap penting untuk memastikan bahwa *unit test* yang dibuat sudah memiliki cakupan pengujian yang baik, mencakup berbagai skenario, termasuk *edge cases*, agar program lebih terpercaya dan bebas dari kesalahan.

2. > Suppose that after writing the CreateProductFunctionalTest.java along with the corresponding test case, you were asked to create another functional test suite that verifies the number of items in the product list. You decided to create a new Java class similar to the prior functional test suites with the same setup procedures and instance variables.
   What do you think about the cleanliness of the code of the new functional test suite? Will the new code reduce the code quality? Identify the potential clean code issues, explain the reasons, and suggest possible improvements to make the code cleaner!

Kode dalam functional test suite baru harus tetap menjaga prinsip *clean code* agar mudah dibaca dan dipelihara. Jika banyak kode dari pengujian sebelumnya disalin tanpa modifikasi, hal ini dapat menyebabkan duplikasi yang tidak perlu dan menurunkan kualitas kode. Selain itu, kurangnya modularitas dan penamaan yang tidak deskriptif dapat membuat pengujian sulit dipahami.