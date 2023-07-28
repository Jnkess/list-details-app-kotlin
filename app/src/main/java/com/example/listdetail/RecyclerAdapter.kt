package com.example.listdetail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val types: Array<String>): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    private val descriptions = mapOf(
        "Pomidorowa 1" to "Składniki:\n -1,5 litra rosołu z kurczaka \n" +
                "-150 g koncentratu pomidorowego \n" +
                "-50ml słodkiej śmietany\n" +
                "-posiekana natka pietruszki makaron (ok. 50 g na osobę) \n" +
                "-sól, czarny pieprz mielony \n\nSposób przygotowania:\n -Ugotować ryż lub makaron według przepisu na opakowaniu. Rosół podgrzać. \n" +
                "-Dodać koncentrat pomidorowy i wymieszać, żeby się rozpuścił. Zagotować. \n" +
                "-Na końcu wmieszać śmietanę. Doprawić ewentualnie do smaku solą i pieprzem. \n" +
                "-Podawać z ugotowanym ryżem lub makaronem.",

        "Schab 2" to "Składniki:\n - 1.5 kilograma schabu\n" +
                "- Sos do pieczeni z cebulką Knorr\n" +
                "- 2 łyżki majeranku\n" +
                "- 2 ząbki czosnku\n" +
                "- woda 1 szklanka\n\nSposób przygotowania:\n - Sos Knorr zagotuj z wodą i dokładnie wymieszaj\n" +
                "- Gdy sos przestygnie, dodaj do niego przeciśnięty przez praskę czosnek oraz majeranek. Ponownie dokładnie wymieszaj.\n" +
                "- Oczyść schab i nasmaruj go dokładnie wystudzonym sosem. Następnie przełóż do naczynia żaroodpornego i odstaw na godzinę do lodówki.\n" +
                "- Naczynie przykryj folią aluminiową i piecz mięso w 160 °C przez godzinę. Podawaj na zimno pokrojone w cienkie plastry. ",

        "Rosół 3" to "Składniki:\n - 1 kurczak o wadze ok. 1,2- 1,5 kg \n" +
                "- 3 litry wody \n" +
                "- 2 marchewki, 2 pietruszki, ok. ¼ korzenia selera, 1 cebula,\n" +
                "- kilka gałązek natki pietruszki, 2 liście laurowe,\n" +
                "- ok. 10 ziarenek pieprzu czarnego 1/2 łyżki soli gałązka świeżego lubczyku (lub 1 łyżeczka suszonego) \n" +
                "- makaron\n\nSposób przygotowania:\n - Kurczaka pokroić na części. Oczyścić, opłukać, przełożyć do garnka i zalać 3 litrami zimnej wody. Doprowadzić do zagotowania.\n" +
                "- Marchewki, pietruszki i seler obrać i pokroić na duże kawałki. Cebulę obrać\n" +
                "- Po zagotowaniu powstanie szumowina, którą należy zebrać łyżką cedzakową\n" +
                "- Do garnka włożyć marchewki, pietruszki, seler, cebulę z łupinami, liście laurowe, ziela angielskie, ziarenka pieprzu.\n" +
                "- Zmniejszyć temperaturę palnika na niską  i gotować bez przykrycia 1 godzinę\n" +
                "- Po godzinie gotowania, dodać sól, natkę pietruszki i lubczyk. Gotować dalej 30 minut. Sprawdzić smak rosołu\n" +
                "- Według uznania doprawić solą i pieprzem do smaku. Podawać z ugotowanym makaronem, pokrojoną marchewką",

        "Naleśniki 4" to "Składniki:\n - 1 szklankamąka przenna\n" +
                "- 1 jajko\n" +
                "- 1 szklanka maślanki naturalnej\n" +
                "- 1 łyżka proszku do pieczenia\n" +
                "- 1 szklanka oliwy\n" +
                "- 1 sody oczyszczonej\n\nSposób przygotowania:\n - Wszystkie składniki miksujemy razem, do konsystencji gęstej śmietany\n" +
                "- Rozgrzewamy patelnię\n" +
                "- Naleśniki smażymy z obu stron\n" +
                "- Do ciasta można dodać czekoladę. Naleśniki możemy podawać z: syropem klonowym, polewą, bitą śmietaną",

        "Barszcz 5" to "Składniki:\n - 2 litry bulionu mięsnego lub warzywnego \n" +
                "- 500g buraków \n" +
                "- 2 ząbki czosnku, 1 łyżka octu (lub soku z cytryny)\n" +
                "- 3 kawałki suszonych grzybów, majeranek ,7 ziarenek czarnego pieprzu, sól, ocet \n\nSposób przygotowania:\n - Buraki obrać i pokroić w niegrube plastry. Bulion zagotować\n" +
                "- Do gotującego dodać buraki razem z łyżką octu. Dodać suszone grzyby, rozgniecione (lub przekrojone na pół) ząbki czosnku i ziarenka pieprzu\n" +
                "- Gotować do miękkości buraków ok. 1 godziny, na małej mocy palnika. ( Podczas gotowania, garnek przykryć pokrywką, pozostawiając małą szczelinę)\n" +
                "- Barszcz przecedzić przez sitko. Doprawić go majerankiem, solą, octem i pieprzem",

        "Jajecznica 6" to "Składniki:\n - jajka – 2-3 szt.\n" +
                "- wędzony boczek – 2 plastry\n" +
                "- cebula – ¼ szt.\n" +
                "- szczypiorek – 2 łyżki\n" +
                "- masło\n" +
                "- sól\n" +
                "- pieprz\n\nSposób przygotowania:\n - Cebulę siekamy w drobną kostkę, boczek kroimy na mniejsze kawałki. Jajka wbijamy do miseczki. Na patelni roztapiamy masło. \n" +
                "- Pokrojoną cebulę wrzucamy na patelnię i czekamy, aż się zeszkli. Jajka doprawiamy solą i pieprzem, a następnie rozbijamy za pomocą trzepaczki. \n" +
                "- Do podsmażonej cebuli dodajemy boczek i lekko podsmażamy. Wlewamy jajka na patelnię i cały czas mieszamy. \n" +
                "-Kiedy jajka się zetną, przekładamy je do miseczki. Siekamy szczypiorek i posypujemy nim gotową jajecznicę.",

        "Grochowa 7" to "Składniki:\n - 1 szklanka żółtego grochu łuskanego połówki\n" +
                "- 700 g żeberek wędzonych lub wędzonych kości wieprzowych\n" +
                "- 2 litry bulionu (np. domowego wieprzowego) lub z kostki\n" +
                "- 1 marchewka\n" +
                "- 500 g ziemniaków\n" +
                "- 1 łyżka suszonego majeranku\n" +
                "- 1 ząbek czosnku\n\nSposób przygotowania:\n - Dzień wcześniej groch wsypać do garnka, zalać zimną wodą i odstawić na noc do namoczenia. Przygotować bulion, przecedzić\n" +
                "- Do gotującego się bulionu włożyć groch i zagotować. Dodać żeberka lub kości wędzone podzielone na 4 mniejsze części.\n" +
                "- Zmniejszyć ogień i gotować pod przykryciem przez 1 godzinę\n" +
                "- Dodać obraną i pokrojoną na cienkie plasterki marchewkę oraz obrane i pokrojone w kosteczkę ziemniaki. Gotować przez około pół godziny.\n" +
                "- Na 10 minut przed końcem dodać majeranek oraz połówkę ząbka czosnku (w całości)\n" +
                "- Zupa z czasem będzie gęstniała. Można zamknąć na gorąco w słoiki i przechowywać przez kilka dni w lodówce.",

        "Zrazy 8" to "Składniki:\n - Schab\n" +
                "- sól, pieprz, musztarda\n" +
                "- wędzony boczek\n" +
                "- cebula\n" +
                "- ogórek kiszony\n\nSposób przygotowania:\n - Schab rozbijamy, przyprawiamy solą pieprzem i smarujemy ostra musztardą. Nadziewamy boczkiem wędzonym, cebulą i ogórkiem kiszonym\n" +
                "- Zwijamy i spinamy wykałaczką. Smażymy aż uzyska złoty kolor. Przekładamy do garnka podlewamy wodą, dodajemy troszkę degusty i gotujmy do miękkości\n" +
                "- Dodajemy koncentrat i kilka kropel tabasco. Gotujemy jeszcze chwilkę aż rozpuści się koncentrat",
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        val type = types[position]
        holder.itemTitle.text = type

        val number = type.filter { it.isDigit() }.toInt()

        val name = type.substringBefore(" ")
        holder.itemTitle.setText(name)

        if (number == 1)
            holder.itemImage.setImageResource(R.drawable.pomidorowa)
        if (number == 2)
            holder.itemImage.setImageResource(R.drawable.schab)
        if (number == 3)
            holder.itemImage.setImageResource(R.drawable.rosol)
        if (number == 4)
            holder.itemImage.setImageResource(R.drawable.nalesniki)
        if (number == 5)
            holder.itemImage.setImageResource(R.drawable.barszcz)
        if (number == 6)
            holder.itemImage.setImageResource(R.drawable.jajecznica)
        if (number == 7)
            holder.itemImage.setImageResource(R.drawable.grochowa)
        if (number == 8)
            holder.itemImage.setImageResource(R.drawable.zrazy)
    }

    override fun getItemCount(): Int {
        return types.size
    }


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemView.setOnClickListener {
                val position: Int = adapterPosition
                val type = types[position]
                val description = descriptions[type]
                val imageId = (type.filter{ it.isDigit() }).toInt()
                replaceFragment(DetailFragment.newInstance(type, description.toString(), imageId))
            }
        }

        private fun replaceFragment(fragment: Fragment) {
            val smallestWidth = itemView.resources.configuration.smallestScreenWidthDp
            val manager = (itemView.context as FragmentActivity).supportFragmentManager
            val fragmentTransaction = manager.beginTransaction()

            if (smallestWidth < 720)
                fragmentTransaction.replace(R.id.fragment_container, fragment)
            else
                fragmentTransaction.replace(R.id.fragment_container2, fragment)

            fragmentTransaction.commit()
        }
    }
}