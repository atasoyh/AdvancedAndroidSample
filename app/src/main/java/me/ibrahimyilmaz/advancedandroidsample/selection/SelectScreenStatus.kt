package me.ibrahimyilmaz.advancedandroidsample.selection

/**
 * * SelectScreenStatus is a enum that shows status of Network calls
 * <p>
 *   ON_LOADING - Network Resource has been requested and hasn't returned any response.
 * <p>
 *    ON_ERROR - It may cover both Network SelectScreenStatus and any Error status in response model.
 *  <p>
 *    ON_SUCCESS - Network Resources has returned successfully
 *  <p>
 *
 *      when (status) {
 *         ViewStatus.ON_LOADING -> {  //show progress bar or something  }
 *         ViewStatus.ON_ERROR -> { show errror message or something }
 *         ViewStatus.ON_SUCCESS-> { do your success plan }
 *         ViewStatus.ON_FINISHED-> { do your finished plan }
 *         }
 */
enum class SelectScreenStatus {
    ON_LOADING, ON_ERROR, ON_SUCCESS, ON_FINISHED
}