import requests


class ReqUsage:
    @staticmethod
    def get_req(url):
        r = requests.get(url)
        return r.status_code, r.text

    @staticmethod
    def post_req(body, url):
        r = requests.post(url,data=body)
        return r.status_code, r.text

    @staticmethod
    def delete_req(url):
        r = requests.delete(url)
        return r.status_code, r.text

    @staticmethod
    def put_req(body, url):
        r = requests.put(url,data=body)
        return r.status_code, r.text