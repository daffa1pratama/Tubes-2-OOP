# Avatar Duel Board Game
## author : K3 Kelompok 9

## Deskripsi Program
Program yang dibuat untuk Tugas Besar 2 IF2210 ini adalah permainan board game bertemakan Avatar: The Legend of Aang. Permainan ini mirip seperti game Yu Gi Oh! dan Magic: The Gathering, dimainkan oleh 2 orang yang bertarung pada sebuah papan permainan dengan menggunakan kartu sebagai alat permainan. Terdapat 3 jenis kartu dasar, yaitu Character Card, Land Card, dan Skill Card. Skill Card dibedakan lagi menjadi 3 jenis, yaitu Aura Card, Destroy Card, dan Power Up Card. Untuk menggunakan kartu, terdapat power untuk setiap elemen kartu yang dapat ditambahkan menggunakan Land Card. Ada 5 elemen kartu, yaitu Water, Earth, Fire, Air, dan Energy.

## Aturan Permainan
* Papan permainan terdiri dari 2 sisi yang merepresentasikan pemain
* Tiap pemain diberi deck sejumlah 50 kartu secara acak
* Pada awal permainan, pemain diberi 7 kartu di tangan dengan total kartu di tangan sebanyak 8 kartu
* Papan permainan dapat diisi maksimum oleh 6 kartu karakter dan 6 kartu skill untuk masing-masing pemain
* Tugas pemain adalah menyerang lawan menggunakan kartu yang tersedia
* Pemain dinyatakan menang jika :
    - Deck lawan telah habis
    - HP lawan 0

## Cara Memainkan
Berikut adalah cara memainkan permainan ini :
1. Pastikan komputer sudah terinstall Java 8
2. Buka terminal pada folder Avatar Board Game
3. Untuk menjalankan permainan, tuliskan kode berikut :
`./gradlew run`
4. Tunggu beberapa saat hingga screen permainan muncul
5. Selamat bertarung!

## Struktur Kode Program
```
C:.
├───bin
│   └───main
│       └───com
│           └───avatarduel
│               ├───board
│               ├───card
│               │   ├───data
│               │   └───image
│               │       ├───character
│               │       ├───element
│               │       ├───land
│               │       └───skill
│               ├───deck
│               ├───fieldcard
│               ├───player
│               ├───util
│               └───views
├───build
│   ├───classes
│   │   └───java
│   │       └───main
│   │           └───com
│   │               └───avatarduel
│   │                   ├───board
│   │                   ├───card
│   │                   ├───deck
│   │                   ├───fieldcard
│   │                   ├───player
│   │                   └───util
│   ├───docs
│   │   └───javadoc
│   │       └───com
│   │           └───avatarduel
│   │               ├───board
│   │               ├───card
│   │               ├───deck
│   │               ├───fieldcard
│   │               ├───player
│   │               └───util
│   ├───generated
│   │   └───sources
│   │       └───annotationProcessor
│   │           └───java
│   │               └───main
│   ├───resources
│   │   └───main
│   │       └───com
│   │           └───avatarduel
│   │               ├───card
│   │               │   ├───data
│   │               │   └───image
│   │               │       ├───character
│   │               │       ├───element
│   │               │       ├───land
│   │               │       └───skill
│   │               └───views
│   └───tmp
│       ├───compileJava
│       └───javadoc
├───gradle
│   └───wrapper
└───src
    └───main
        ├───java
        │   └───com
        │       └───avatarduel
        │           ├───board
        │           ├───card
        │           ├───deck
        │           ├───fieldcard
        │           ├───player
        │           └───util
        └───resources
            └───com
                └───avatarduel
                    ├───card
                    │   ├───data
                    │   └───image
                    │       ├───character
                    │       ├───element
                    │       ├───land
                    │       └───skill
                    └───views
```

## Credit
Gambar kartu dan deskripsi diambil dari [Avatar Wikia](https://avatar.fandom.com/wiki/Avatar_Wiki)
Background board dan gambar elemen diambil dari [Google Image](https://images.google.com)
