package com.swancodes.countriesoftheworld.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.viewpager.widget.ViewPager
import com.swancodes.countriesoftheworld.R
import com.swancodes.countriesoftheworld.databinding.FragmentDetailsBinding
import com.swancodes.countriesoftheworld.model.CountryBaseResponseItem
import me.relex.circleindicator.CircleIndicator

class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    lateinit var pager: ViewPager
    lateinit var pagerAdapter: ImagePagerAdapter
    private lateinit var imageList: CountryBaseResponseItem
    lateinit var indicator: CircleIndicator
    private var items: List<CountryBaseResponseItem>? = null
    private val args by navArgs<DetailsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*imageList.flags.png.let {
            pagerAdapter = ImagePagerAdapter(requireContext(), items )
            pager.adapter = pagerAdapter
            indicator = requireView().findViewById(R.id.indicator) as CircleIndicator
            indicator.setViewPager(pager)}*/

        val countries = args.country
        binding.apply {
            bodyTextOne.text = getString(R.string.population, countries.population)
            bodyTextTwo.text = getString(R.string.region, countries.region)
            bodyTextThree.text = countries.capitalInfo.toString()
            bodyTextFour.text = getString(R.string.sub_region, countries.subregion)
            bodyTextFive.text = getString(R.string.area, countries.area)
            bodyTextSix.text = getString(R.string.independence, countries.independent)
            bodyTextSeven.text = getString(R.string.continent, countries.continents)
            bodyTextEight.text = getString(R.string.start_of_the_week, countries.startOfWeek)
            bodyTextNine.text = getString(R.string.driving_side, countries.car.side)
            bodyTextTen.text = getString(R.string.time_zone, countries.timezones)
            bodyTextEleven.text = getString(R.string.un_member, countries.unMember)
            bodyTextTwelve.text = getString(R.string.status, countries.status)
            bodyTextThirteen.text = getString(R.string.land_locked, countries.landlocked)
            bodyTextFourteen.text = getString(R.string.fifa, countries.fifa)
            bodyTextFifteen.text = getString(R.string.borders, countries.borders)

        }
    }
}