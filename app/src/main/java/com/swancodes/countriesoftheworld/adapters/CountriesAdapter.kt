package com.swancodes.countriesoftheworld.adapters

/*
class CountriesAdapter(
    private val context: Context,
    private val data: List<CountryBaseResponseItem>
) : RecyclerView.Adapter<CountriesAdapter.CountriesViewHolder>() {

    class CountriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val flag: ImageView = view.findViewById(R.id.flagImage)
        val title: TextView = view.findViewById(R.id.title)
        val capital: TextView = view.findViewById(R.id.capital)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.country_list_items, parent, false)
        return CountriesViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        val country = data[position]
        */
/*holder.flag.setImageDrawable()
        holder.title.text = context.resources.getString()*//*

        holder.capital.text = context.resources.getString(country.capital.size)
    }

    override fun getItemCount() = data.size


*/