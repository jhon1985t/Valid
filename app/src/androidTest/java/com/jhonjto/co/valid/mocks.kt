import com.jhonjto.co.domain.*

/**
 * Created by jhon on 7/05/2020
 */
val mockedArtistsList = DomainResponseArtist(
    topArtists = DomainTopArtists(
        attr = DomainAttr(
            country = "Colombia",
            page = "1",
            perPage = "1",
            total = "10",
            totalPages = "100"
        ),
        artist = listOf(
                DomainArtist(
                        image = listOf(
                                DomainImage(
                                        text = "no image",
                                        size = "not size"
                                )
                        ) as ArrayList<DomainImage>,
                        listeners = "15000",
                        mbid = "0",
                        name = "Radio",
                        streamable = "yes",
                        url = "www.radio.com"
                )
        ) as ArrayList<DomainArtist>
    )
)