from unittest import TestCase


class TestClass(TestCase):
    def testA(self):
        self.assertEqual(1, 1)

    def testC(self):
        self.assertIn("R", "Rasha")

    def testB(self):
        self.assertTrue(False)

    def test_d(self):
        self.assertIn("F", "Rasha")

    @classmethod
    def setUpClass(cls):
        print("setUpClass")

    @classmethod
    def tearDownClass(cls):
        print("tearDownClass")

    def setUp(self):
        print("setUp")

    def tearDown(self):
        print("tearDown")
