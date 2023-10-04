import axios from "axios";

async function getUser({ headers }) {
    try {
        const { data } = await axios({ headers, url: "api/user"} )
    }
}