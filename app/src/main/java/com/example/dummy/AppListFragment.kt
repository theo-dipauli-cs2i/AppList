package com.example.dummy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dummy.adapter.ApplicationAdapter
import com.example.dummy.databinding.FragmentAppListBinding
import com.example.dummy.models.Application
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class AppListFragment : Fragment() {

    private val applications = mutableListOf<Application>()
    private var _binding: FragmentAppListBinding? = null
    private val binding get() = _binding!!
    private var isGrid = false


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAppListBinding.inflate(inflater, container, false)
        createApplication()
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        displayApps(isGrid)

        val fab = binding.fab

        fab.setOnClickListener {
            isGrid = !isGrid
            displayApps(isGrid)
            updateFabIcon(fab, isGrid)
        }
    }



    fun createApplication() {
        applications.add(Application("Clash Royal", "Supercell", "Entrez dans l'arène ! Les créateurs de Clash of Clans vous offrent un jeu multijoueur en temps réel mettant en scène des combattants royaux, vos personnages préférés de Clash of Clans et beaucoup plus encore.", 4.6, 1000000, R.drawable.clash_royale))
        applications.add(Application("King of Avalon", "DIANDIAN INTERACTIVE", "Fais toi des alliés et combats des ennemis du monde entier, ton dragon et le trône t’attendent !", 4.2, 500000, R.drawable.dragon_warfare))
        applications.add(Application("Idle Heroes", "DHGAMES", "Rejoignez des millions de joueurs de toute la planète et commencez votre journée de la Foret de Sara jusqu'au Paradis Volant et menez vos héros aux ancienne ruines pour vaincre les forces du mal !", 4.7, 2000000, R.drawable.idle_heroes))
        applications.add(Application("Suzy Cube", "NOODLECAKES STUDIO INC", "Oh non ! Ces vilains Nonos ont volé tout l'or caché au château de Cubeton ! Seule Suzy Cube peut récupérer les trésors du château volés par ces vilains pas beaux !", 4.3, 1500000, R.drawable.suzy_cube))
        applications.add(Application("Bacterial Takeover - idle clicker", "SIA FUFLA", "Bienvenue, docteur ! Nous vous avons attendu. Tout est préparé pour que vous preniez le relais et que vous commenciez à cultiver des bactéries pour initier une prise de conscience bactérienne !", 4.5, 800000, R.drawable.bacterial_takeover))
        applications.add(Application("Clash Royal", "Supercell", "Entrez dans l'arène ! Les créateurs de Clash of Clans vous offrent un jeu multijoueur en temps réel mettant en scène des combattants royaux, vos personnages préférés de Clash of Clans et beaucoup plus encore.", 4.6, 1000000, R.drawable.clash_royale))
        applications.add(Application("King of Avalon", "DIANDIAN INTERACTIVE", "Fais toi des alliés et combats des ennemis du monde entier, ton dragon et le trône t’attendent !", 4.2, 500000, R.drawable.dragon_warfare))
        applications.add(Application("Idle Heroes", "DHGAMES", "Rejoignez des millions de joueurs de toute la planète et commencez votre journée de la Foret de Sara jusqu'au Paradis Volant et menez vos héros aux ancienne ruines pour vaincre les forces du mal !", 4.7, 2000000, R.drawable.idle_heroes))
        applications.add(Application("Suzy Cube", "NOODLECAKES STUDIO INC", "Oh non ! Ces vilains Nonos ont volé tout l'or caché au château de Cubeton ! Seule Suzy Cube peut récupérer les trésors du château volés par ces vilains pas beaux !", 4.3, 1500000, R.drawable.suzy_cube))
        applications.add(Application("Bacterial Takeover - idle clicker", "SIA FUFLA", "Bienvenue, docteur ! Nous vous avons attendu. Tout est préparé pour que vous preniez le relais et que vous commenciez à cultiver des bactéries pour initier une prise de conscience bactérienne !", 4.5, 800000, R.drawable.bacterial_takeover))
    }

    fun displayApps(isGrid: Boolean){
        val appRecyclerView = binding.recyclerView

        if (isGrid) {
            val applicationAdapter = ApplicationAdapter(requireContext(), R.layout.item_application_grid, applications)
            appRecyclerView.adapter = applicationAdapter
            appRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        } else {
            val applicationAdapter = ApplicationAdapter(requireContext(), R.layout.item_application, applications)
            appRecyclerView.adapter = applicationAdapter
            appRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun updateFabIcon(fab: FloatingActionButton, isGrid: Boolean) {
        if (isGrid) {
            fab.setImageResource(R.drawable.view_list)
        } else {
            fab.setImageResource(R.drawable.grid_view)
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}