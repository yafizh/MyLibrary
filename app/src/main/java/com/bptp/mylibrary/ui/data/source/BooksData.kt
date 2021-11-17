package com.bptp.mylibrary.ui.data.source

import com.bptp.mylibrary.R
import com.bptp.mylibrary.ui.data.model.Hero

object BooksData {
    private val bookNames = arrayOf(
        "Homo Deus: Masa Depan Umat Manusia",
        "Sapiens: Riwayat Singkat Umat Manusia",
        "Evolusi: Dari Teori ke Fakta",
        "How to be a Brilliant Thinker: Latih pikiran Anda dan temukan solusi-solusi kreatif",
        "Sebuah Seni Untuk Bersikap Bodo Amat",
        "Madilog: Materialisme, Dialektika, dan Logika",
        "A Whole New Mind: Pemikiran yang benar-benar baru dan komplet",
        "I Want to Die But I Want to Eat Tteokpokki",
        "How To Die",
        "Dunia Sophie",
        "Buku Panduan Matematika Terapan",
        "Underground",
    )

    private val bookCategory = arrayOf(
        "Filsafat",
        "Sejarah",
        "Ilmu Pengetahuan Terapan",
        "Ilmu Pengetahuan Terapan",
        "Umum",
        "Ilmu Pengetahuan Terapan",
        "Literatur",
        "Umum",
        "Filsafat",
        "Filsafat",
        "Literatur",
        "Literatur"
    )
    private val bookAuthors = arrayOf(
        "Yuval Noah Harari",
        "Yuval Noah Harari",
        "Ernst Mayr",
        "Paul Sloane",
        "Mark Manson",
        "Tan Malaka",
        "Daniel H. Pink",
        "Baek Se Hee",
        "Seneca",
        "Jostein Gaarder",
        "Triskaidekaman",
        "Ika Natassa",
    )

    private val bookDescriptions = arrayOf(
        "Homo Deus: A Brief History of Tomorrow is a book written by Israeli author Yuval Noah Harari, professor at the Hebrew University in Jerusalem. The book was first published in Hebrew in 2015 by Dvir publishing; the English-language version was published in September 2016 in the United Kingdom and in February 2017 in the United States. ",
        "Sapiens: A Brief History of Humankind is a book by Yuval Noah Harari, first published in Hebrew in Israel in 2011 based on a series of lectures Harari taught at The Hebrew University of Jerusalem, and in English in 2014.[1][2] The book, focusing on Homo sapiens, surveys the history of humankind, starting from the Stone Age, and going up to the twenty-first century. The account is situated within a framework that intersects the natural sciences with the social sciences. ",
        "Evolusi adalah salah satu gagasan ilmiah yang paling sering disalahgunakan dan disalahmengerti. Baik profesional maupun awam, sering keliru memahai teori ini kendati sudah silam hampir dua abad. Kesulitan itu dipahami dan ditangkap oleh Ernst Mayr sehingga ia menulis buku ini.",
        "Di satu sisi, memuat sejumlah teori, di sisi lain dan barangkali hal ini lebih penting lagi, buku ini dilengkapi dengan saran-saran praktis dan contoh-contoh nyata tentang bagaimana para pemikir hebat, sekalipun berasal dari kelas orang kebanyakan, membuka pikiran mereka terhadap proses berpikir yang baru dan mengasyikkan, dan menuai hasil yang memuaskan dengan berbagai cara.",
        "The Subtle Art of Not Giving a Fuck: A Counterintuitive Approach to Living a Good Life is the second book by blogger and author Mark Manson. In it Manson argues that life's struggles give it meaning, and that the mindless positivity of typical self-help books is neither practical nor helpful.",
        "The Madilog by Iljas Hussein, first published in 1943, official first edition 1951, is the magnum opus of Tan Malaka, the Indonesian national hero and is the most influential work in the history of modern Indonesian philosophy. Madilog is an Indonesian acronym that stands for Materialisme Dialektika Logika.",
        "The future belongs to a different kind of person with a different kind of mind: artists, inventors, storytellers-creative and holistic “right-brain” thinkers whose abilities mark the fault line between who gets ahead and who doesn’t.",
        "I Want To Die But I Want To Eat Tteokpokki adalah esai yang berisi tentang pertanyaan, penilaian, saran, nasihat, dan evaluasi diri yang bertujuan agar pembaca bisa menerima dan mencintai dirinya.",
        "\"It takes an entire lifetime to learn how to die,\" wrote the Roman Stoic philosopher Seneca (c. 4 BC–65 AD). He counseled readers to \"study death always,\" and took his own advice, returning to the subject again and again in all his writings, yet he never treated it in a complete work. ",
        "Sophie's World is a 1991 novel by Norwegian writer Jostein Gaarder. It follows Sophie Amundsen, a Norwegian teenager, who is introduced to the history of philosophy as she is asked \"Who are you?\" in a letter from an unknown philosopher.",
        "Pertanyaan P-NP (sesuatu yang bisa diperhitungkan-sesuatu yang tidak bisa diperhitungkan) muncul setelah Prima didatangi oleh hantu yang mengajarinya cara berhitung dan berbagai teori matematika di dalam mimpi. Teka-teki itu semakin mengusiknya ketika ia bertemu Tarsa—si cerdas yang juga memiliki pertanyaan sama tentang P-NP. Namun, meski telah mencurahkan seluruh hidupnya, Prima tak juga mampu menemukan jawabannya. Tentu. Karena, siapa pula manusia di dunia ini yang bisa menjawab kapan ia akan dimatikan?",
        "Selamat datang di Underground, stasiun televisi musik terbesar di Amerika Serikat, tempat para entertainer muda dan VJ, icon kehidupan metropolis, menjalani hari-hari normal mereka, itu jika anda bisa bilang bahwa hidup 10 jam sehari dalam sorotan lampu studio, terbang bolak balik dengan Marquis Jet meliput AmsterJam dan Live 8, dan berpose untuk cover Rolling Stone biasa-biasa saja."
    )

    private val bookImages = arrayOf(
        R.drawable.homo_deus,
        R.drawable.sapiens,
        R.drawable.evolusi,
        R.drawable.how_to_be_a_brilliant_thinker,
        R.drawable.sebuah_seni_untuk_bersikap_bodo_amat,
        R.drawable.madilog,
        R.drawable.a_whole_new_mind,
        R.drawable.i_want_to_die,
        R.drawable.how_to_die,
        R.drawable.dunia_sophie,
        R.drawable.panduan_mtk,
        R.drawable.underground
    )
    val listData: ArrayList<Hero>
        get() {
            val list = arrayListOf<Hero>()
            for (position in bookNames.indices) {
                val hero = Hero()
                hero.bookAuthor = bookAuthors[position]
                hero.bookName = bookNames[position]
                hero.bookImage = bookImages[position]
                hero.bookDescription = bookDescriptions[position]
                hero.bookCategory = bookCategory[position]
                list.add(hero)
            }
            return list
        }
}
