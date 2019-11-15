package com.michaldrabik.showly2.ui.settings

import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.michaldrabik.showly2.Config.MY_SHOWS_RECENTS_OPTIONS
import com.michaldrabik.showly2.R
import com.michaldrabik.showly2.appComponent
import com.michaldrabik.showly2.ui.common.base.BaseFragment
import com.michaldrabik.showly2.ui.main.MainActivity
import com.michaldrabik.showly2.utilities.extensions.onClick
import kotlinx.android.synthetic.main.fragment_settings.*

class SettingsFragment : BaseFragment<SettingsViewModel>() {

  override val layoutResId = R.layout.fragment_settings

  override fun onCreate(savedInstanceState: Bundle?) {
    appComponent().inject(this)
    super.onCreate(savedInstanceState)
  }

  override fun createViewModel(provider: ViewModelProvider) =
    provider.get(SettingsViewModel::class.java)

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    settingsToolbar.setNavigationOnClickListener { activity?.onBackPressed() }

    settingsRecentShowsAmount.onClick {
      AlertDialog.Builder(requireContext())
        .setSingleChoiceItems(MY_SHOWS_RECENTS_OPTIONS, 0) { dialog, index ->
          dialog.dismiss()
        }
        .show()
    }
  }

  override fun onResume() {
    super.onResume()
    handleBackPressed()
  }

  private fun handleBackPressed() {
    val dispatcher = requireActivity().onBackPressedDispatcher
    dispatcher.addCallback(viewLifecycleOwner) {
      remove()
      (activity as MainActivity).showNavigation()
      findNavController().popBackStack()
    }
  }
}